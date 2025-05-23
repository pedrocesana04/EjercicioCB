package org.ejercicio.dto;
import java.math.BigDecimal;

public class IdAmountDTO {
    private long credit_id;
    private BigDecimal amount;

    public IdAmountDTO(long credit_id, BigDecimal amount) {
        this.credit_id = credit_id;
        this.amount = amount;
    }

    public long getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(long credit_id) {
        this.credit_id = credit_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
