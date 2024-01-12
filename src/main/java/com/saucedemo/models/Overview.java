package com.saucedemo.models;

public class Overview extends Product {

    private String tax;
    private String total;
    private String itemTotal;

    public Overview(String name, String price, String description, String tax, String total, String itemTotal) {
        super(name, price, description);
        this.tax = tax;
        this.total = total;
        this.itemTotal = itemTotal;
    }

    public Overview(String name, String price, String description) {
        super(name, price, description);
    }

    public Overview() {

    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(String itemTotal) {
        this.itemTotal = itemTotal;
    }

    public float CalculatorTotal() {
        float Tax = Float.parseFloat(getTax());
        float ItemTotal = Float.parseFloat(getItemTotal());
        float Total = Tax + ItemTotal;
        return Total;
    }
}
