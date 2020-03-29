package com.tcs.batch.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionid")
    private Integer transactionId;
    @Column(name="time")
    private Date time;
    @Column(name="amount")
    private double amount;
    @Column(name="updatetype")
    private String updateType;
    @Column(name="status")
    private String status;
    @Column(name="result")
    private String result;
    @Column(name="fromaccountid")
    private Integer fromAccountId;
    @Column(name="toaccountid")
    private Integer toAccountId;

    public Transaction(){}

    public Transaction(Integer transactionId, Date time, double amount, String updateType, String status, String result, Integer fromAccountId, Integer toAccountId) {
        this.transactionId = transactionId;
        this.time = time;
        this.amount = amount;
        this.updateType = updateType;
        this.status = status;
        this.result = result;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }
}
