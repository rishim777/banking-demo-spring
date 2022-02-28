package org.example.model;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private Long id;
    private Long customer_id;
    private String opening_date;
    private String account_type;
    private Double amount;
    private Integer status;

    public Long getId() {
        return id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public String getOpening_date() {
        return opening_date;
    }

    public String getAccount_type() {
        return account_type;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public void setOpening_date(String opening_date) {
        this.opening_date = opening_date;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", opening_date='" + opening_date + '\'' +
                ", account_type='" + account_type + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
