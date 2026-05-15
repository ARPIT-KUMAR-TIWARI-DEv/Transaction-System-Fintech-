package com.arpit.pfms.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String invoiceNumber;

    private String customerName;
    private String customerEmail;

    @Column(nullable = false)
    private BigDecimal amount;

    private String description;

    // PENDING, PAID
    private String status;

    private String pdfPath;

    private LocalDateTime createdAt;

    // ---------------- Constructors ----------------

    public Invoice() {
    }

    public Invoice(Long id, User user, String invoiceNumber, String customerName,
                   String customerEmail, BigDecimal amount, String description,
                   String status, String pdfPath, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.pdfPath = pdfPath;
        this.createdAt = createdAt;
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

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}