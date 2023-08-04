package com.miskevich.homeworkAtm;

public class DebitCard extends Card {
    public DebitCard(String ownerName, double balance) {
        super(ownerName, balance);
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
}