package org.ejercicio.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private long Payment_id;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit Credit;

    @Column(name = "pay_date")
    private LocalDate Pay_date;

    @Column(name = "amount", precision = 12, scale = 2)
    private BigDecimal Amount;

    public long getPayment_id() {
        return Payment_id;
    }

    public void setPayment_id(long payment_id) {
        Payment_id = payment_id;
    }

    public Credit getCredit_id() {
        return Credit;
    }

    public void setCredit_id(Credit credit_id) {
        Credit = credit_id;
    }

    public LocalDate getPay_date() {
        return Pay_date;
    }

    public void setPay_date(LocalDate pay_date) {
        Pay_date = pay_date;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }
}
