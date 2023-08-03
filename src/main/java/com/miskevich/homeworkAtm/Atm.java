package com.miskevich.homeworkAtm;

import java.util.Scanner;

public class Atm {
    private Card card;

    public Atm(Card card) {
        this.card = card;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance");
            System.out.println("4. Convert balance");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    double depositAmount = 0;
                    while (true) {
                        try {
                            System.out.print("Enter amount to deposit: ");
                            depositAmount = Double.parseDouble(scanner.next());
                            if (depositAmount < 0) throw new NumberFormatException();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a positive number.");
                        }
                    }
                    card.deposit(depositAmount);
                    break;

                case 2:
                    double withdrawAmount = 0;
                    while (true) {
                        try {
                            System.out.print("Enter amount to withdraw: ");
                            withdrawAmount = Double.parseDouble(scanner.next());
                            if (withdrawAmount < 0 || withdrawAmount > card.getBalance()) throw new NumberFormatException();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a positive number less than or equal to your current balance.");
                        }
                    }
                    if (!card.withdraw(withdrawAmount)) {
                        System.out.println("Insufficient funds");
                    }
                    break;

                case 3:
                    System.out.println("Balance: " + card.getBalance());
                    break;

                case 4:
                    double rate = 0;
                    while (true) {
                        try {
                            System.out.print("Enter conversion rate: ");
                            rate = Double.parseDouble(scanner.next());
                            if (rate < 0) throw new NumberFormatException();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a positive number.");
                        }
                    }

                    String currency = "";
                    while (!currency.equals("USD") && !currency.equals("EUR")) {
                        System.out.print("Enter target currency (USD or EUR): ");
                        currency = scanner.next();
                        if (!currency.equals("USD") && !currency.equals("EUR")) {
                            System.out.println("Invalid input. Please enter USD or EUR.");
                        }
                    }

                    System.out.println("Converted balance: " + card.convertBalance(rate, currency));
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
}
