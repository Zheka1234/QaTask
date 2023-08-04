package com.miskevich.homeworkAtm;

import com.miskevich.homeworkAtm.serviceatm.implatm.CardImpl;

public class DebitCard extends CardImpl {
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