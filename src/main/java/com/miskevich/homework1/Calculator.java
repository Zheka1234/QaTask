package com.miskevich.homework1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        double num1;

        double num2;

        double result;

        char operator;

        Scanner reader = new Scanner(System.in);

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
                operator = reader.next().charAt(0);
                if(operator == '+' || operator == '-' || operator == '*' || operator == '/')
                    break;
                else
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
                    System.out.println("Error: Division by zero.");
                    return;
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
                return;
        }
        System.out.print("Result: ");
        System.out.printf(num1 + " " + operator + " " + num2 + " = " + result);
    }


}