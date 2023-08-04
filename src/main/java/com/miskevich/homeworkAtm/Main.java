package com.miskevich.homeworkAtm;

import com.miskevich.homeworkAtm.serviceatm.CardFactory;
import com.miskevich.homeworkAtm.serviceatm.implatm.CardFactoryImpl;
import com.miskevich.homeworkAtm.serviceatm.implatm.CardImpl;

public class Main {
    public static void main(String[] args) {

        CardFactory cardFactory = new CardFactoryImpl();
        CardImpl card = cardFactory.createCard();
        Atm atm = new Atm(card);
        atm.run();

    }
}

