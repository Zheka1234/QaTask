package com.miskevich.homeworkAtm.serviceatm;

import com.miskevich.homeworkAtm.serviceatm.implatm.CardImpl;

public interface CardFactory {
    CardImpl createCard();

    boolean isValidOwnerName(String name);

}