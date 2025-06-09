package model;

import java.io.Serializable;

public class Transaction implements Serializable {
    private String type; // Income or Expense
    private String category;
    private String date;
    private double amount;
    private boolean isRecurring;

    public Transaction(String type, String category, String date, double amount, boolean isRecurring) {
        this.type = type;
        this.category = category;
        this.date = date;
        this.amount = amount;
        this.isRecurring = isRecurring;
    }

    public String getType() { return type; }
    public String getCategory() { return category; }
    public String getDate() { return date; }
    public double getAmount() { return amount; }
    public boolean isRecurring() { return isRecurring; }

    public void setType(String type) { this.type = type; }
    public void setCategory(String category) { this.category = category; }
    public void setDate(String date) { this.date = date; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setRecurring(boolean isRecurring) { this.isRecurring = isRecurring; }

    @Override
    public String toString() {
        return type + " | " + category + " | " + date + " | Rs. " + amount + (isRecurring ? " | Recurring" : "");
    }
}