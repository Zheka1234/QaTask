package com.miskevich.homeworkSql.service4.impl4;

import com.miskevich.homeworkSql.service4.BankingAppInterface;

import java.util.Scanner;

public class BankingApp implements BankingAppInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static BankingSystem bankingSystem = new BankingSystem();
    private static AccountManager accountManager = new AccountManager(bankingSystem);

    @Override
    public void startProgram() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an action:");
            System.out.println("1. Create an account");
            System.out.println("2. Deposit account");
            System.out.println("3. Withdraw with account");
            System.out.println("4. Delete account");
            System.out.println("5. End the program");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    accountManager.createAccountFromInput();
                    break;
                case 2:
                    accountManager.depositFromInput();
                    break;
                case 3:
                    accountManager.withdrawFromInput();
                    break;
                case 4:
                    accountManager.deleteAccountFromInput();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Incorrect choice. Please select again.");
                    break;
            }
        }
    }
}
