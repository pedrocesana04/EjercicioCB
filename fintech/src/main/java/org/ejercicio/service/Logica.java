package org.ejercicio.service;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Join;
import org.hibernate.*;
import org.ejercicio.utils.HibernateUtil;
import javax.net.ssl.HandshakeCompletedEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import java.util.stream.Collectors;
import org.ejercicio.models.Credit;
import org.ejercicio.models.Payment;

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

    public boolean GenerarPago ( long credit_id, BigDecimal amount){
        try(Session session = HibernateUtil.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Credit> query = cb.createQuery(Credit.class);
            Root<Credit> credit = query.from(Credit.class);
            query.select(credit).where(cb.equal(credit.get("credit_id"), credit_id));
            Credit creditResult = session.createQuery(query).uniqueResult();
            if (creditResult == null) {
                return false;
            }
            Payment nuevoPago = new Payment();
        }
    }
}
