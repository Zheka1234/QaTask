package com.miskevich.homeworkAtm.serviceatm.implatm;

import com.miskevich.homeworkAtm.CreditCard;
import com.miskevich.homeworkAtm.DebitCard;
import com.miskevich.homeworkAtm.serviceatm.ICard;

public class CardImpl implements ICard {
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
    public boolean withdraw(double amount) {
        if (this instanceof DebitCard) {
            if (amount <= balance) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        } else if (this instanceof CreditCard) {
            increaseDebt(amount);
            return true;
        }
        return false;
    }

    @Override
    public double convertBalance(double rate, String currency) {
        if (currency.equals("BYR")) {
            return balance;
        } else if (currency.equals("USD")) {
            return balance / rate;
        } else {
            throw new IllegalArgumentException("Incorrect currency: " + currency);
        }
    }

    @Override
    public void increaseDebt(double amount) {
        debt += amount;
    }


}