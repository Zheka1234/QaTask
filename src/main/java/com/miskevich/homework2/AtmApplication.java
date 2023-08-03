package com.miskevich.homework2;

import java.util.Scanner;

public class AtmApplication {
    private final Atm atm;
    private final Scanner scanner;
    public AtmApplication() {
        this.atm = new Atm();
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        setupCard();
        while (true) {
            chooseOperation();
        }
    }
    private void setupCard() {
        System.out.print("Введите имя владельца карты: ");
        String ownerName = scanner.nextLine();
        System.out.print("Введите начальный баланс карты (если нет, введите 0): ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Выберите тип карты (1 - DebitCard, 2 - CreditCard): ");
        int cardType = scanner.nextInt();
        scanner.nextLine();
        if (cardType == 1) {
            atm.setCard(new DebitCard(ownerName, balance));
        } else if (cardType == 2) {
            atm.setCard(new CreditCard(ownerName, balance));
        }
    }
    private void chooseOperation() {
        System.out.println("\nВыберите операцию:");
        System.out.println("1. Пополнить баланс");
        System.out.println("2. Снять средства в BYR");
        System.out.println("3. Снять средства в USD");
        System.out.println("4. Показать баланс");
        System.out.println("5. Выйти");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            deposit();
        } else if (choice == 2) {
            withdraw();
        } else if (choice == 3) {
            withdrawInUSD();
        } else if (choice == 4) {
            atm.getBalance();
        } else if (choice == 5) {
            scanner.close();
            System.exit(0);
        }
    }
    private void deposit() {
        System.out.print("Введите сумму для пополнения: ");
        double amount = scanner.nextDouble();
        atm.deposit(amount);
    }
    private void withdraw() {
        System.out.print("Введите сумму для снятия: ");
        double amount = scanner.nextDouble();
        atm.withdraw(amount);
    }
    private void withdrawInUSD() {
        System.out.print("Введите сумму в USD для снятия: ");
        double amount = scanner.nextDouble();
        atm.withdrawInUSD(amount);
    }
}