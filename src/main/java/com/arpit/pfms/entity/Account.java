package com.arpit.pfms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String bankName;

    private String accountNumber;   // Will be encrypted

    private String ifscCode;

    private String accountType;     // SAVINGS, CURRENT, WALLET

    private boolean isUpiEnabled = true;

    private String upiId;

    // ---------------- Constructors ----------------

    public Account() {
    }

    public Account(Long id, User user, String bankName, String accountNumber,
                   String ifscCode, String accountType,
                   boolean isUpiEnabled, String upiId) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.accountType = accountType;
        this.isUpiEnabled = isUpiEnabled;
        this.upiId = upiId;
    }

    // ---------------- Getters & Setters ----------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public boolean isUpiEnabled() {
        return isUpiEnabled;
    }

    public void setUpiEnabled(boolean upiEnabled) {
        isUpiEnabled = upiEnabled;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }
}