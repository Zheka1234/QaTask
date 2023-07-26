package com.miskevich.homework1.service.impl;

import com.miskevich.homework1.service.CalculatorInput;
import com.miskevich.homework1.service.ContinueInput;
import com.miskevich.homework1.service.NumberInput;
import com.miskevich.homework1.service.OperationInput;


import java.util.Scanner;

public class CalculatorInputImpl implements CalculatorInput {

    private NumberInput numberInput;

    private OperationInput operatorInput;

    private ContinueInput continueInput;


    public CalculatorInputImpl(NumberInput numberInput, OperationInput operatorInput, ContinueInput continueInput) {
        this.numberInput = numberInput;
        this.operatorInput = operatorInput;
        this.continueInput = continueInput;
    }



    @Override
    public void start() {

        Scanner reader = new Scanner(System.in);

        double num1;

        double num2;

        char operator;

        double result;

        do {
            num1 = numberInput.getNumberInput(reader, "Enter first number: ");
            num2 = numberInput.getNumberInput(reader, "Enter second number: ");
            operator = operatorInput.getOperatorInput(reader);
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
                                " If the user is already dividing by 0, then I don't want to work with a bad user and terminate the program");
                        return;
                    }
                    break;
                default:
                    System.out.println("Ошибка: Неверный оператор.");
                    return;
            }
            System.out.print("Результат: ");
            System.out.printf(num1 + " " + operator + " " + num2 + " = " + result);
        } while (continueInput.askForContinue(reader));
    }


}
