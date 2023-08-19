package com.miskevich.homeworkSql;

import com.miskevich.homeworkSql.service4.BankingAppInterface;
import com.miskevich.homeworkSql.service4.impl4.BankingApp;

public class BankStart {

    public static void main(String[] args) {
        BankingAppInterface app = new BankingApp();

        app.startProgram();
    }
}