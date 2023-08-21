package com.miskevich.homework1;

import com.miskevich.homework1.service.impl.CalculatorInputImpl;
import com.miskevich.homework1.service.impl.ContinueInputImpl;
import com.miskevich.homework1.service.impl.NumberInputImpl;
import com.miskevich.homework1.service.impl.OperatorInputImpl;

public class CalculatorStart {
    public static void main(String[] args) {


        CalculatorInputImpl calculator = new CalculatorInputImpl(new NumberInputImpl(), new OperatorInputImpl(), new ContinueInputImpl()) {
        };
        calculator.start();
    }
}