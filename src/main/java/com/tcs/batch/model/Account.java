package com.tcs.batch.model;


import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Transactional
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountid;
    @Column(name = "balance")
    private double balance;
    private String userid;

    public Account() {
    }

    public Account(Integer accountid, double balance, String userid) {
        this.accountid = accountid;
        this.balance = balance;
        this.userid = userid;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
