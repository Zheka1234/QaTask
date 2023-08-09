package com.miskevich.homeworkAtm.serviceatm;

public interface ICard {
    String getOwnerName();

    double getBalance();

    void deposit(double amount);

    boolean withdraw(double amount);


    void increaseDebt(double amount);

    double convertCurrency(double amount, double exchangeRate);
}
