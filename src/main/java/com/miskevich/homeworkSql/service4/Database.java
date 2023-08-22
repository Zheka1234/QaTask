package com.miskevich.homeworkSql.service4;

import java.sql.SQLException;

public interface Database {
    void createTables() throws SQLException;

    void registerUser(String name, String address);

    void addAccount(int userId, double initialBalance, String currency);

    void deposit(int accountId, double amount);

    void withdraw(int accountId, double amount);

    boolean checkActiveAccounts(int userId);

    void deleteUser(int userId);

    void getUserAccounts(int userId);

    void deleteAccount(int accountId);

    boolean isAccountExists(int accountId);


}
