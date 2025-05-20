package org.ejercicio.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "credit")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private long Payment_id;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private long Credit_id;

    @Column(name = "pay_day")
    private Date Pay_day;

    @Column(name = "amount", precision = 12, scale = 2)
    private BigDecimal Amount;

    public long getPayment_id() {
        return Payment_id;
    }

    public void setPayment_id(long payment_id) {
        Payment_id = payment_id;
    }

    public long getCredit_id() {
        return Credit_id;
    }

    public void setCredit_id(long credit_id) {
        Credit_id = credit_id;
    }

    public Date getPay_day() {
        return Pay_day;
    }

    public void setPay_day(Date pay_day) {
        Pay_day = pay_day;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }
}
