package com.miskevich.homeworkAtm.serviceatm;

public interface ICard {
    String getOwnerName();

    double getBalance();

    void deposit(double amount);

    boolean withdraw(double amount);

    double convertBalance(double rate, String currency);

    void increaseDebt(double amount);
}
