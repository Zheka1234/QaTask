package com.miskevich.homeworkAtm;

import java.util.InputMismatchException;
import java.util.Scanner;


public class CardFactoryImpl implements CardFactory {
    @Override
    public Card createCard() {
        Scanner scanner = new Scanner(System.in);
        String ownerName = "";
        while (ownerName.isEmpty() || !isValidOwnerName(ownerName)) {
            System.out.print("Введите имя владельца (только латинские буквы): ");
            ownerName = scanner.nextLine();
        }
        double balance = 0;
        boolean isValidBalance = false;
        while (!isValidBalance) {
            try {
                System.out.print("Введите начальный баланс (неотрицательное число): ");
                balance = scanner.nextDouble();
                isValidBalance = isValidBalance(balance);
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введен некорректный баланс. Попробуйте снова.");
                scanner.nextLine(); // очистка буфера ввода
            }
        }
        int cardType = 0;
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                System.out.print("Выберите тип карты (1 для кредитной карты, 2 для дебетовой карты): ");
                cardType = scanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введен некорректный тип карты. Попробуйте снова.");
                scanner.nextLine(); // очистка буфера ввода
            }
        }
        switch (cardType) {
            case 1:
                return new CreditCard(ownerName, balance);
            case 2:
                return new DebitCard(ownerName,balance);
            default:
                throw new IllegalArgumentException("Неверный тип карты");
        }
    }
    private boolean isValidOwnerName(String name) {
        return name.matches("[a-zA-Z]+");
    }
    private boolean isValidBalance(double balance) {
        return balance >= 0;
    }
}