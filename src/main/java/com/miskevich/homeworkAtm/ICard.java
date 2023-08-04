package com.miskevich.homeworkAtm;

public interface ICard {
    String getOwnerName();
    double getBalance();
    void deposit(double amount);
    boolean withdraw(double amount);
    double convertBalance(double rate, String currency);
}
