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
                if (scanner.hasNextDouble()) {
                    balance = scanner.nextDouble();
                    if (balance >= 0) {
                        isValidBalance = true;
                    } else {
                        System.out.println("Ошибка: введен некорректный баланс. Пожалуйста, введите неотрицательное число.");
                    }
                } else {
                    System.out.println("Ошибка: введен некорректный баланс. Пожалуйста, введите неотрицательное число.");
                    scanner.next(); // очистка буфера ввода
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введен некорректный баланс. Пожалуйста, введите неотрицательное число.");
                scanner.next(); // очистка буфера ввода
            }
        }
        int cardType = 0;
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                System.out.print("Выберите тип карты (1 для кредитной карты, 2 для дебетовой карты): ");
                if (scanner.hasNextInt()) {
                    cardType = scanner.nextInt();
                    if (cardType == 1 || cardType == 2) {
                        isValidInput = true;
                    } else {
                        System.out.println("Ошибка: введен некорректный тип карты. Пожалуйста, введите 1 или 2.");
                    }
                } else {
                    System.out.println("Ошибка: введен некорректный тип карты. Пожалуйста, введите 1 или 2.");
                    scanner.next(); // очистка буфера ввода
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введен некорректный тип карты. Пожалуйста, введите 1 или 2.");
                scanner.next(); // очистка буфера ввода
            }
        }
        switch (cardType) {
            case 1:
                return new CreditCard(ownerName, balance);
            case 2:
                return new DebitCard(ownerName, balance);
            default:
                throw new IllegalArgumentException("Неверный тип карты");
        }
    }
    private boolean isValidOwnerName(String name) {
        return name.matches("[a-zA-Z]+");
    }
}