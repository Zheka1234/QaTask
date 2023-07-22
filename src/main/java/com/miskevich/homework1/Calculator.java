package com.miskevich.homework1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        char operator;

        double num1;

        double num2;

        double result;

        do {
            while (true) {
                try {
                    System.out.print("Enter the first number: ");
                    num1 = reader.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Error: Invalid input. Please try again.");
                    reader.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Enter the second number: ");
                    num2 = reader.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Error: Invalid input. Please try again.");
                    reader.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Choose an operator (+, -, *, /): ");
                    String input = reader.next();
                    if (input.length() == 1) {
                        operator = input.charAt(0);
                        if (operator == '+' || operator == '-' || operator == '*' || operator == '/')
                            break;
                    }
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Error: Invalid operator. Please try again.");
                    reader.nextLine();
                }
            }
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero!!!" +
                                "If the user is already dividing by 0, then I don't want to work with a bad user and shut down");
                        return;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator.");
                    return;
            }

            System.out.print("Result: ");
            System.out.printf(num1 + " " + operator + " " + num2 + " = " + result);

            while (true) {
                System.out.println("\nDo you want to continue? (y/n): ");
                String choice = reader.next();
                if (choice.length() == 1) {
                    if (choice.equalsIgnoreCase("y")) {
                        break;
                    } else if (choice.equalsIgnoreCase("n")) {
                        System.exit(0);
                    }
                }
                System.out.println("Error: Invalid input. Type 'y' to continue or 'n' to end: ");
            }
        } while (true);
    }
}
