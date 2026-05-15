package com.arpit.pfms.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.arpit.pfms.entity.TransactionType;

public class TransactionRequest {

    private BigDecimal amount;
    private TransactionType type;
    private String category;
    private String description;
    private String merchant;
    private LocalDateTime transactionDate;

    // No-Args Constructor
    public TransactionRequest() {
    }

    // All-Args Constructor
    public TransactionRequest(BigDecimal amount, TransactionType type,
                              String category, String description,
                              String merchant, LocalDateTime transactionDate) {

        this.amount = amount;
        this.type = type;
        this.category = category;
        this.description = description;
        this.merchant = merchant;
        this.transactionDate = transactionDate;
    }

    // Getter and Setter for amount
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    // Getter and Setter for type
    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    // Getter and Setter for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for merchant
    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    // Getter and Setter for transactionDate
    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}