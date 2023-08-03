package com.miskevich.homeworkAtm;

import java.util.Scanner;

public class AtmMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Atm atm = new Atm();
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
        while (true) {
            System.out.println("\nВыберите операцию:");
            System.out.println("1. Пополнить баланс");
            System.out.println("2. Снять средства в BYR");
            System.out.println("3. Снять средства в USD");
            System.out.println("4. Показать баланс");
            System.out.println("5. Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Введите сумму для пополнения: ");
                double amount = scanner.nextDouble();
                atm.deposit(amount);
            } else if (choice == 2) {
                System.out.print("Введите сумму для снятия: ");
                double amount = scanner.nextDouble();
                atm.withdraw(amount);
            } else if (choice == 3) {
                System.out.print("Введите сумму в USD для снятия: ");
                double amount = scanner.nextDouble();
                atm.withdrawInUSD(amount);
            } else if (choice == 4) {
                atm.getBalance();
            } else if (choice == 5) {
                break;
            }
        }
        scanner.close();
    }
}
