package com.miskevich.homeworkAtm;

public class Main {


        public static void main(String[] args) {
            CardFactory cardFactory = new CardFactoryImpl();
            Card card = cardFactory.createCard();
            Atm atm = new Atm(card);
            atm.run();
        }}

