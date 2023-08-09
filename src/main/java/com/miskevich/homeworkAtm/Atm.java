package com.miskevich.homeworkAtm;

import com.miskevich.homeworkAtm.exceptions.InsufficientFundsException;
import com.miskevich.homeworkAtm.serviceatm.ICard;
import com.miskevich.homeworkAtm.serviceatm.implatm.CardImpl;

import java.util.Scanner;

public class Atm {

    private ICard card;

    public Atm(CardImpl card) {
        this.card = card;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw funds in BYR");
            System.out.println("3. Withdraw funds in USD");
            System.out.println("4. Balance");
            System.out.println("5. Exit");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect choice. Please enter a number from 1 to 5.");
                continue;
            }
            switch (choice) {
                case 1:
                    double depositAmount = 0;
                    while (true) {
                        try {
                            System.out.print("Enter the amount to replenish: ");
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
                    double withdrawAmountBYR = 0;
                    while (true) {
                        try {
                            System.out.print("Enter the amount to withdraw in BYR: ");
                            withdrawAmountBYR = Double.parseDouble(scanner.next());
                            if (withdrawAmountBYR < 0) throw new NumberFormatException();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a positive number.");
                        }
                    }
                    try {
                        boolean success = card.withdraw(withdrawAmountBYR);
                        if (success) {
                            System.out.println("Withdrawal completed successfully");
                        } else {
                            System.out.println("Insufficient funds on the card");
                        }
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    double withdrawAmountUSD = 0;
                    while (true) {
                        try {
                            System.out.print("Enter the amount to withdraw in USD: ");
                            withdrawAmountUSD = Double.parseDouble(scanner.next());
                            if (withdrawAmountUSD < 0) throw new NumberFormatException();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a positive number.");
                        }
                    }
                    double withdrawAmountBYRConverted = card.convertCurrency(withdrawAmountUSD, 3);
                    try {
                        boolean success = card.withdraw(withdrawAmountBYRConverted);
                        if (success) {
                            System.out.println("Withdrawal completed successfully");
                        } else {
                            System.out.println("Insufficient funds on the card");
                        }
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Balance: " + card.getBalance() + " BYR");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Incorrect choice. Please enter a number from 1 to 5.");
            }
            System.out.println();
        }
    }
}