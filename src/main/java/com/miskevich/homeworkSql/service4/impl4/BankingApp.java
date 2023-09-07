package com.miskevich.homeworkSql.service4.impl4;

import com.miskevich.homeworkSql.service4.BankingAppInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingApp implements BankingAppInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static BankingSystem bankingSystem = new BankingSystem();
    private static AccountManager accountManager = new AccountManager(bankingSystem);

    @Override
    public void startProgram() {
        boolean exit = false;
        boolean createAccountDone = false;
        boolean addAccountDone = false;

        while (!exit) {
            System.out.println("Choose an action:");

            if (!createAccountDone && !addAccountDone) {
                System.out.println("1. Create an account");
                System.out.println("2. Add account to existing user");
            } else {
                System.out.println("3. Deposit account");
                System.out.println("4. Withdraw with account");
                System.out.println("5. Delete account");
                System.out.println("6. End the program");
            }

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        if (!createAccountDone) {
                            accountManager.createAccountFromInput();
                            createAccountDone = true;
                        } else {
                            throw new Exception("You have already created an account.");
                        }
                        break;
                    case 2:
                        if (!addAccountDone) {
                            accountManager.addAccountToExistingUser();
                            addAccountDone = true;
                        } else {
                            throw new Exception("You have already added an account to an existing user.");
                        }
                        break;
                    case 3:
                        if (createAccountDone || addAccountDone)  {
                            accountManager.depositFromInput();
                        } else {
                            throw new Exception("Please complete the previous steps.");
                        }
                        break;
                    case 4:
                        if (createAccountDone || addAccountDone) {
                            accountManager.withdrawFromInput();
                        } else {
                            throw new Exception("Please complete the previous steps.");
                        }
                        break;
                    case 5:
                        if (createAccountDone || addAccountDone) {
                            accountManager.deleteAccountFromInput();
                        } else {
                            throw new Exception("Please complete the previous steps.");
                        }
                        break;
                    case 6:
                        if (createAccountDone || addAccountDone) {
                            exit = true;
                        } else {
                            throw new Exception("Please complete the previous steps.");
                        }
                        break;
                    default:
                        throw new Exception("Incorrect choice. Please select again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input Error. Please enter a number.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}