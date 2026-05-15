package com.arpit.pfms.dto;

import java.math.BigDecimal;

public class InvestmentRequest {

    private String assetType;
    private String symbol;
    private BigDecimal quantity;
    private BigDecimal buyPrice;

    // ---------------- Constructors ----------------

    public InvestmentRequest() {
    }

    public InvestmentRequest(String assetType, String symbol,
                             BigDecimal quantity, BigDecimal buyPrice) {
        this.assetType = assetType;
        this.symbol = symbol;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
    }

    // ---------------- Getters & Setters ----------------

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }
}