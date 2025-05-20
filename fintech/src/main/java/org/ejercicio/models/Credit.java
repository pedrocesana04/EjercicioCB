package org.ejercicio.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import org.ejercicio.models.Enums.Credit_Types;
import org.ejercicio.models.Enums.Status;

@Entity
@Table(name = "credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private long Credit_id;

    @Column(name ="client_name" , length = 80)
    private String Client_name;

    @Column(name = "credit_type")
    private Credit_Types Credit_type;

    @Column(name = "principal_amount", precision = 12, scale = 2)
    private BigDecimal Principal_amount;

    @Column(name = "interest_rate", precision = 5, scale = 2)
    private BigDecimal Interest_rate;

    @Column(name = "start_date")
    private Date Start_date;

    @Column(name = "end_date")
    private Date End_date;

    @Column(name = "status")
    private Status Status;

    public long getCredit_id() {
        return Credit_id;
    }

    public void setCredit_id(long credit_id) {
        Credit_id = credit_id;
    }

    public String getClient_name() {
        return Client_name;
    }

    public void setClient_name(String client_name) {
        Client_name = client_name;
    }

    public Credit_Types getCredit_type() {
        return Credit_type;
    }

    public void setCredit_type(Credit_Types credit_type) {
        Credit_type = credit_type;
    }

    public BigDecimal getInterest_rate() {
        return Interest_rate;
    }

    public void setInterest_rate(BigDecimal interest_rate) {
        Interest_rate = interest_rate;
    }

    public BigDecimal getPrincipal_amount() {
        return Principal_amount;
    }

    public void setPrincipal_amount(BigDecimal principal_amount) {
        Principal_amount = principal_amount;
    }

    public Date getStart_date() {
        return Start_date;
    }

    public void setStart_date(Date start_date) {
        Start_date = start_date;
    }

    public Date getEnd_date() {
        return End_date;
    }

    public void setEnd_date(Date end_date) {
        End_date = end_date;
    }

    public org.ejercicio.models.Enums.Status getStatus() {
        return Status;
    }

    public void setStatus(org.ejercicio.models.Enums.Status status) {
        Status = status;
    }
}
