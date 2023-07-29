package com.miskevich.homework2;

class DebitCard extends Card {
    public DebitCard(String ownerName, double balance) {
        super(ownerName, balance);
    }
    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= 0) {
            super.withdraw(amount);
        } else {
            System.out.println("Недостаточно средств на карте");
        }
    }
}
