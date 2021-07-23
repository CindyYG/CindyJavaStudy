package com.CYG.SmallChangeProject;

import java.time.LocalDateTime;

public class Data {
    private String item;
    private double amount;
    private LocalDateTime dateTime;
    private double balance;

    public Data(String item, double amount) {
        this.item = item;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
