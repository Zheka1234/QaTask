package com.miskevich.homeworkAtm;

import java.util.Scanner;
import java.util.Scanner;
public class Atm {
    private Card card;
    public Atm(Card card) {
        this.card = card;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Пополнить счет");
            System.out.println("2. Снять средства");
            System.out.println("3. Баланс");
            System.out.println("4. Конвертировать баланс");
            System.out.println("5. Выход");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 5.");
                continue;
            }
            switch (choice) {
                case 1:
                    double depositAmount = 0;
                    while (true) {
                        try {
                            System.out.print("Введите сумму для пополнения: ");
                            depositAmount = Double.parseDouble(scanner.next());
                            if (depositAmount < 0) throw new NumberFormatException();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректный ввод. Пожалуйста, введите положительное число.");
                        }
                    }
                    card.deposit(depositAmount);
                    break;
                case 2:
                    double withdrawAmount = 0;
                    while (true) {
                        try {
                            System.out.print("Введите сумму для снятия: ");
                            withdrawAmount = Double.parseDouble(scanner.next());
                            if (withdrawAmount < 0) throw new NumberFormatException();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректный ввод. Пожалуйста, введите положительное число.");
                        }
                    }
                    if (!card.withdraw(withdrawAmount)) {
                        System.out.println("Недостаточно средств");
                    }
                    break;
                case 3:
                    System.out.println("Баланс: " + card.getBalance());
                    break;
                case 4:
                    double rate = 0;
                    while (true) {
                        try {
                            System.out.print("Введите курс конвертации: ");
                            rate = Double.parseDouble(scanner.next());
                            if (rate < 0) throw new NumberFormatException();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректный ввод. Пожалуйста, введите положительное число.");
                        }
                    }
                    String currency = "";
                    while (!currency.equals("USD") && !currency.equals("EUR")) {
                        System.out.print("Введите целевую валюту (USD или EUR): ");
                        currency = scanner.next();
                        if (!currency.equals("USD") && !currency.equals("EUR")) {
                            System.out.println("Некорректный ввод. Пожалуйста, введите USD или EUR.");
                        }
                    }
                    System.out.println("Конвертированный баланс: " + card.convertBalance(rate, currency));
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 5.");
            }
            System.out.println();
        }
    }}