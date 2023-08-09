package com.miskevich.homeworkAtm.serviceatm.implatm;


import com.miskevich.homeworkAtm.serviceatm.ICard;

public abstract class CardImpl implements ICard {
    private String ownerName;
    protected double balance;
    protected double debt;

    public CardImpl(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
        this.debt = 0;
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
    public abstract boolean withdraw(double amount);

    @Override
    public void increaseDebt(double amount) {
        debt += amount;
    }

    @Override
    public double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }


}