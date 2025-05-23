package org.ejercicio.service;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.ejercicio.dto.IdAmountDTO;
import org.ejercicio.models.Enums.Status;
import org.hibernate.*;
import org.ejercicio.utils.HibernateUtil;
import org.ejercicio.models.Credit;
import org.ejercicio.models.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logica {
    private static Logica instance;

    private Logica() {
    }

    public static Logica getInstance() {
        if (instance == null) {
            instance = new Logica();
        }
        return instance;
    }

    public boolean generarPago (IdAmountDTO idAmountDTO) {
        Credit creditResult = new Credit();
        try (Session session = HibernateUtil.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Credit> query = cb.createQuery(Credit.class);
            Root<Credit> credit = query.from(Credit.class);

            query.where(cb.equal(credit.get("credit").get("credit_id"), idAmountDTO.getCredit_id()));
            creditResult = session.createQuery(query).uniqueResult();
            if (creditResult == null) {
                return false;
            }
        }
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Payment payment = new Payment();
            payment.setCredit_id(creditResult);
            payment.setAmount(idAmountDTO.getAmount());
            payment.setPay_date(LocalDate.now());
            session.save(payment);
            session.getTransaction().commit();
        }
        List<Payment> paymentResult = new ArrayList<>();
        try (Session session = HibernateUtil.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Payment> query = cb.createQuery(Payment.class);
            Root<Payment> payment = query.from(Payment.class);

            query.select(payment).
                    where(cb.equal(payment.get("credit").get("credit_id"), idAmountDTO.getCredit_id()));
            paymentResult = session.createQuery(query).getResultList();
        }
        BigDecimal totalPayments = BigDecimal.ZERO;
        for (Payment payment : paymentResult) {
            totalPayments = totalPayments.add(payment.getAmount());
        }
        if ((((creditResult.getPrincipal_amount()).add(creditResult.getInterest_rate())).compareTo(totalPayments)) >= 0) {
            try (Session session = HibernateUtil.getSession()) {
                session.beginTransaction();
                creditResult.setStatus(Status.PAID);
                session.update(creditResult);
                session.getTransaction().commit();
            }
        } else {
            try (Session session = HibernateUtil.getSession()) {
                session.beginTransaction();
                if (creditResult.getEnd_date().isBefore(LocalDate.now())) {
                    creditResult.setStatus(Status.OVERDUE);
                    creditResult.setStatus(Status.OVERDUE);
                    session.update(creditResult);
                    session.getTransaction().commit();
                }
            }
        }
        return true;
    }
}
