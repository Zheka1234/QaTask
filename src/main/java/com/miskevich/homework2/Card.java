package com.miskevich.homework2;

class Card {
    private String ownerName;
    private double balance;
    private final String currency = "BYR";
    public Card(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }
    public Card(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0.0;
    }
    public double getBalance() {
        return balance;
    }
    public String getCurrency() {
        return currency;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Баланс пополнен на " + amount + " " + currency);
    }
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Снято " + amount + " " + currency);
    }
    public void withdrawInUSD(double amount) {
        double amountInBYR = amount * 3;
        if(balance >= amountInBYR) {
            balance -= amountInBYR;
            System.out.println("Снято " + amount + " USD" );
        } else {
            System.out.println("Недостаточно средств на карте");
        }
    }
}
