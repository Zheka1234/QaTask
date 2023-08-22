package com.miskevich.homeworkSql.service4.impl4;

import com.miskevich.homeworkSql.service4.Account;
import com.miskevich.homeworkSql.service4.Database;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager implements Account {
    private Database database;

    public AccountManager(Database database) {
        this.database = database;
    }

    @Override
    public void createAccountFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String name = scanner.nextLine();

        System.out.println("Enter user address:");
        String address = scanner.nextLine();

        database.registerUser(name, address);

        int userId = 0;
        boolean validUserId = false;
        while (!validUserId) {
            try {
                System.out.println("Enter user ID:");
                userId = scanner.nextInt();
                validUserId = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid user ID. Please enter a number.");
                scanner.nextLine();
            }
        }

        double initialBalance = 0;
        boolean validInitialBalance = false;
        while (!validInitialBalance) {
            try {
                System.out.println("Enter your initial account balance:");
                initialBalance = scanner.nextDouble();
                validInitialBalance = true;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect initial account balance. Please enter a number.");
                scanner.nextLine();
            }
        }

        System.out.println("Enter account currency:");
        String currency = scanner.next();

        database.addAccount(userId, initialBalance, currency);
    }

    @Override
    public void depositFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user ID:");
        int userId = 0;
        while (true) {
            try {
                userId = scanner.nextInt();
                if (!database.checkActiveAccounts(userId)) {
                    System.out.println("The user has no active accounts." +
                            " Please enter an existing user ID with active accounts:");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer:");
                scanner.nextLine();
            }
        }
        showUserAccounts(userId);

        System.out.println("Enter account ID:");
        int accountId;
        while (true) {
            try {
                accountId = scanner.nextInt();
                if (!database.isAccountExists(accountId)) {
                    System.out.println("The account does not exist. Please enter an existing account ID:");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer:");
                scanner.nextLine();
            }
        }

        System.out.println("Enter the amount to replenish:");
        double amount;
        while (true) {
            try {
                amount = scanner.nextDouble();
                String[] amountParts = String.valueOf(amount).split("\\.");
                if (amountParts.length > 1 && amountParts[1].length() > 3) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number with no more than 3 decimal places:");
                scanner.nextLine();
            }
        }

        database.deposit(accountId, amount);
    }

    @Override
    public void withdrawFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user ID:");
        int userId = 0;
        while (true) {
            try {
                userId = scanner.nextInt();
                if (!database.checkActiveAccounts(userId)) {
                    System.out.println("The user has no active accounts." +
                            " Please enter an existing user ID with active accounts:");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer:");
                scanner.nextLine();
            }
        }
        showUserAccounts(userId);

        System.out.println("Enter account ID:");
        int accountId;
        while (true) {
            try {
                accountId = scanner.nextInt();
                if (!database.isAccountExists(accountId)) {
                    System.out.println("The account does not exist. Please enter an existing account ID:");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer:");
                scanner.nextLine();
            }
        }

        System.out.println("Enter amount to withdraw:");
        double amount;
        while (true) {
            try {
                amount = scanner.nextDouble();
                String[] amountParts = String.valueOf(amount).split("\\.");
                if (amountParts.length > 1 && amountParts[1].length() > 3) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number with no more than 3 decimal places:");
                scanner.nextLine();
            }
        }

        database.withdraw(accountId, amount);
    }

    @Override
    public void deleteAccountFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user ID:");
        int userId;
        while (true) {
            try {
                userId = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number:");
                scanner.nextLine();
            }
        }

        showUserAccounts(userId);

        System.out.println("Enter account ID:");
        int accountId;
        while (true) {
            try {
                accountId = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number:");
                scanner.nextLine();
            }
        }

        database.deleteAccount(accountId);
    }

    @Override
    public void showUserAccounts(int userId) {
        database.getUserAccounts(userId);
    }

    @Override
    public void addAccountFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user ID:");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter opening balance:");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter account currency:");
        String currency = scanner.nextLine();

        database.addAccount(userId, initialBalance, currency);
    }

    @Override
    public void addAccountToExistingUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an existing user ID:");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Do you want to add a new account for this user? (Yes/no)");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("Yes")) {
            addAccountFromInput();
        }
    }
}
