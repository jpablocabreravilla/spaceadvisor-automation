package com.spaceadvisor.models;

public class OrderSummary {

    private final String dateRange;
    private final String travelers;
    private final String unitPrice;
    private final String totalPrice;

    public OrderSummary(String dateRange, String travelers, String unitPrice, String totalPrice) {
        this.dateRange = dateRange;
        this.travelers = travelers;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public String getDates()      { return dateRange; }
    public String getTravelers()  { return travelers; }
    public String getUnitPrice()  { return unitPrice; }
    public String getTotalPrice() { return totalPrice; }
}
