package com.miskevich.homeworkAtm;

public class CreditCard extends Card {
    public CreditCard(String ownerName, double balance) {
        super(ownerName, balance);
    }
    @Override
    public boolean withdraw(double amount) {
        balance -= amount;
        return true;
    }
}

