
package com.arpit.pfms.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BudgetRequest {

    private String category;
    private BigDecimal amount;
    private LocalDate startDate;
    private LocalDate endDate;

    // No-Args Constructor
    public BudgetRequest() {
    }

    // All-Args Constructor
    public BudgetRequest(String category, BigDecimal amount,
                         LocalDate startDate, LocalDate endDate) {

        this.category = category;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getter and Setter for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Getter and Setter for amount
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    // Getter and Setter for startDate
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    // Getter and Setter for endDate
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

