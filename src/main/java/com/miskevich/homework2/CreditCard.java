package com.miskevich.homework2;

class CreditCard extends Card {
    public CreditCard(String ownerName, double balance) {
        super(ownerName, balance);
    }
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        if (getBalance() < 0) {
            System.out.println("Долг накоплен: " + Math.abs(getBalance()) + " " + getCurrency());
        }
    }
    @Override
    public void withdrawInUSD(double amount) {
        double amountInBYR = amount * 3;
        if(getBalance() >= amountInBYR) {
            super.withdrawInUSD(amount);
        } else {
            super.withdraw(amountInBYR);
            if (getBalance() < 0) {
                System.out.println("Долг накоплен: " + Math.abs(getBalance()) + " " + getCurrency());
            }
        }
    }
}
