package com.company;

public class Item {
    private String name;
    private double price;
    private int quantity;
    private boolean taxable;
    private String state;
    private final double MD_RATE = 6;
    private final double DC_RATE = 5.3;
    private final double VA_RATE = 5.75;
    private final double OTHER_RATE = 5;

    public Item(String name, double price, int quantity, boolean taxable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.taxable = taxable;
        this.state = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalWithTax() {
        return getPriceWithTax() * getQuantity();
    }

    public double getTotal() {
        return getPrice() * getQuantity();
    }

    public double getPriceWithTax() {
        if (taxable) {
            return price + (price * (getRate() / 100));
        } else {
            return price;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public void setState(String state) {
        state = state.toUpperCase();
        if (state.equals("MD")) {
            this.state = "MD";
        } else if (state.equals("DC")) {
            this.state = "DC";
        } else if (state.equals("VA")) {
            this.state = "VA";
        } else {
            this.state = "";
        }
    }

    public String getState() {
        return state;
    }

    public double getRate() {
        if (state.equals("MD")) {
            return  MD_RATE;
        } else if (state.equals("DC")) {
            return DC_RATE;
        } else if (state.equals("VA")) {
            return  VA_RATE;
        } else {
            return OTHER_RATE;
        }
    }

    public static String round(double value) {
        return String.format("%.2f", value);
    }
}
