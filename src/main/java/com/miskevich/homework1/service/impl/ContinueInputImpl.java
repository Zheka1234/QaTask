package com.miskevich.homework1.service.impl;

import com.miskevich.homework1.service.ContinueInput;

import java.util.Scanner;

public class ContinueInputImpl implements ContinueInput {

    @Override
    public boolean askForContinue(Scanner reader) {

        while (true) {
            System.out.print("\nDo you want to continue? (y/n): ");
            String choice = reader.next();
            if (choice.length() == 1) {
                if (choice.equalsIgnoreCase("y")) {
                    return true;
                } else if (choice.equalsIgnoreCase("n")) {
                    return false;
                }
            }
            System.out.println("Error: Invalid input. Type 'y' to continue or 'n' to end: ");
        }
    }
}
