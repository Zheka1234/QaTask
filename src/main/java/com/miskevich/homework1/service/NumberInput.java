package com.miskevich.homework1.service;

import java.util.Scanner;

public interface NumberInput {

    double getNumberInput(Scanner reader, String message);

    float getNumberInputFloat(Scanner reader, String message);

    long getNumberInputLong(Scanner reader, String message);

    int getNumberInputInt(Scanner reader, String message);

//    String getStringInput(Scanner reader, String message);


}
