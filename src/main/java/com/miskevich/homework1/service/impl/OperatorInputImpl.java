package com.miskevich.homework1.service.impl;

import com.miskevich.homework1.service.OperationInput;

import java.util.Scanner;

public class OperatorInputImpl implements OperationInput {

    @Override
    public char getOperatorInput(Scanner reader) {

        char operator;

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
        return operator;
    }

}
