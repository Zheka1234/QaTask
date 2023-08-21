package com.miskevich.homework1.service.impl;

import com.miskevich.homework1.service.NumberInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberInputImpl implements NumberInput {

    @Override
    public double getNumberInput(Scanner reader, String message) {
        double number;

        while (true) {
            try {
                System.out.print(message);
                number = reader.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please try again.");
                reader.nextLine();
            }
        }
        return number;
    }



}
