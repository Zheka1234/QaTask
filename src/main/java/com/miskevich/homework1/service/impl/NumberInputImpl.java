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

    @Override
    public float getNumberInputFloat(Scanner reader, String message) {
        float number;

        while (true) {
            try {
                System.out.print(message);
                number = reader.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please try again.");
                reader.nextLine();
            }
        }
        return number;
    }

    @Override
    public long getNumberInputLong(Scanner reader, String message) {
        long number;

        while (true) {
            try {
                System.out.print(message);
                number = reader.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please try again.");
                reader.nextLine();
            }
        }
        return number;
    }

    @Override
    public int getNumberInputInt(Scanner reader, String message) {
        int number;

        while (true) {
            try {
                System.out.print(message);
                number = reader.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please try again.");
                reader.nextLine();
            }
        }
        return number;
    }

//        @Override
//    public String getStringInput(Scanner reader, String message) {
//        String number;
//
//        while (true) {
//            try {
//                System.out.print(message);
//                number = String.valueOf(reader.nextInt());
//                break;
//            } catch (InputMismatchException e) {
//                System.out.println("Error: Invalid input. Please try again.");
//                reader.nextLine();
//            }
//        }
//        return number;
//    }
//    @Override
//    public String getStringInput(Scanner reader, String message) {
//        System.out.print(message);
//        return reader.nextLine();
//    }

}
