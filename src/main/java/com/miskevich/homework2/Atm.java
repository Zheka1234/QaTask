package com.miskevich.homework2;

class Atm {
    private Card card;
    public void setCard(Card card) {
        this.card = card;
    }
    public void deposit(double amount) {
        card.deposit(amount);
    }
    public void withdraw(double amount) {
        card.withdraw(amount);
    }
    public void withdrawInUSD(double amount) {
        card.withdrawInUSD(amount);
    }
    public void getBalance() {
        if (card.getBalance() < 0) {
            System.out.println("Баланс карты: " + card.getBalance() + " " + card.getCurrency() + ". Долг: " + Math.abs(card.getBalance()) + " " + card.getCurrency());
        } else {
            System.out.println("Баланс карты: " + card.getBalance() + " " + card.getCurrency());
        }
    }
}
