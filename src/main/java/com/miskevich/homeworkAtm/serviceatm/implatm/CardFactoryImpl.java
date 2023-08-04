package com.miskevich.homeworkAtm.serviceatm.implatm;

import com.miskevich.homeworkAtm.CreditCard;
import com.miskevich.homeworkAtm.DebitCard;
import com.miskevich.homeworkAtm.serviceatm.CardFactory;

import java.util.InputMismatchException;
import java.util.Scanner;


public class CardFactoryImpl implements CardFactory {

    @Override
    public CardImpl createCard() {
        Scanner scanner = new Scanner(System.in);
        String ownerName = "";
        while (ownerName.isEmpty() || !isValidOwnerName(ownerName)) {
            System.out.print("Enter the owner's name (only latin letters): ");
            ownerName = scanner.nextLine();
        }
        double balance = 0;
        boolean isValidBalance = false;
        while (!isValidBalance) {
            System.out.print("Enter the opening balance (non-negative number): ");
            try {
                balance = scanner.nextDouble();
                if (balance >= 0) {
                    isValidBalance = true;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a non-negative number.");
                scanner.nextLine();
            }
        }
        int cardType = 0;
        boolean isValidInput = false;
        while (!isValidInput) {
            System.out.print("Select card type (1 for credit card, 2 for debit card): ");
            try {
                cardType = scanner.nextInt();
                if (cardType == 1 || cardType == 2) {
                    isValidInput = true;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid card type entered. Please enter 1 or 2.");
                scanner.nextLine();
            }
        }
        switch (cardType) {
            case 1:
                return new CreditCard(ownerName, balance);
            case 2:
                return new DebitCard(ownerName, balance);
            default:
                throw new IllegalArgumentException("Invalid card type");
        }
    }

    @Override
    public boolean isValidOwnerName(String name) {
        return name.matches("[a-zA-Z]+");
    }
}