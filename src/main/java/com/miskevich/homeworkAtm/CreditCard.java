package com.miskevich.homeworkAtm;

import com.miskevich.homeworkAtm.serviceatm.implatm.CardImpl;

public class CreditCard extends CardImpl {
    public CreditCard(String ownerName, double balance) {
        super(ownerName, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            double remainingAmount = amount - balance;
            balance = -remainingAmount;
            increaseDebt(remainingAmount);
        }
        return true;
    }
}