package main.java.payment_recommendation;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List items;
    private String businessLine;
    private double totalAmount;

    public Cart(String businessLine) {
        this.businessLine = businessLine;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addItem(CartItem item) {
        items.add(item);
        totalAmount += item.price;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public String getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

// Getters
}
