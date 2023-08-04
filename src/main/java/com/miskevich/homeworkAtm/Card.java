package com.miskevich.homeworkAtm;

public class Card implements ICard {
    private String ownerName;
    protected double balance;
    public Card(String ownerName, double balance) {
        if (!isValidOwnerName(ownerName)) {
            throw new IllegalArgumentException("Некорректное имя владельца: " + ownerName);
        }
        this.ownerName = ownerName;
        this.balance = balance;
    }
    @Override
    public String getOwnerName() {
        return ownerName;
    }
    @Override
    public double getBalance() {
        return balance;
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
    }
    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public double convertBalance(double rate, String currency) {
        if (currency.equals("USD")) {
            return balance / rate;
        } else if (currency.equals("EUR")) {
            return balance / rate * 1.2;
        } else {
            throw new IllegalArgumentException("Некорректная валюта: " + currency);
        }
    }
    private boolean isValidOwnerName(String name) {
        return name.matches("[a-zA-Z]+");
    }
}