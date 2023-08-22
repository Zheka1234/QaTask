package com.miskevich.homeworkSql.service4.impl4;

import com.miskevich.homeworkSql.service4.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystem implements Database {

    private Connection connection;

    public BankingSystem() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Professional\\Downloads\\Sql\\SQLiteDatabaseBrowserPortable\\banking_system.db");

            createTables();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTables() throws SQLException {
        Statement statement = connection.createStatement();

        statement.execute("CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "name TEXT (50)," +
                "address TEXT (255)" +
                ")");

        statement.execute("CREATE TABLE IF NOT EXISTS accounts (" +
                "id INTEGER  PRIMARY KEY AUTOINCREMENT," +
                "userId INTEGER (10)," +
                "balance REAL (15)," +
                "currency TEXT (10)," +
                "FOREIGN KEY (userId) REFERENCES users(id)" +
                ")");

        statement.execute("CREATE TABLE IF NOT EXISTS transactions (" +
                "transactionId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "accountId INTEGER (10)," +
                "amount REAL (15)," +
                "FOREIGN KEY (accountId) REFERENCES accounts(id)" +
                ")");
    }

    @Override
    public void registerUser(String name, String address) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, address) VALUES (?, ?)");
            statement.setString(1, name);
            statement.setString(2, address);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAccount(int userId, double initialBalance, String currency) {
        try {
            PreparedStatement checkStatement = connection.prepareStatement("SELECT * FROM accounts WHERE userId = ? AND currency = ?");
            checkStatement.setInt(1, userId);
            checkStatement.setString(2, currency);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("The user already has an account in this currency");
                System.out.println("Want to create a new account with a different currency? Yes/no");

                Scanner scanner = new Scanner(System.in);
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("Yes")) {
                    System.out.println("Enter a new currency to create an account:");
                    String newCurrency = scanner.nextLine();
                    addAccount(userId, initialBalance, newCurrency);
                }
            } else {
                PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO accounts (userId, balance, currency) VALUES (?, ?, ?)");
                insertStatement.setInt(1, userId);
                insertStatement.setDouble(2, initialBalance);
                insertStatement.setString(3, currency);
                insertStatement.executeUpdate();

                System.out.println("Account created successfully!");
                System.out.println("User ID: " + userId);
                System.out.println("Initial balance: " + initialBalance);
                System.out.println("Currency: " + currency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposit(int accountId, double amount) {
        try {
            if (!isAccountExists(accountId)) {
                System.out.println("The account does not exist. Please enter an existing account ID.");
                return;
            }

            PreparedStatement checkAccountStatement = connection.prepareStatement("SELECT * FROM accounts WHERE id = ?");
            checkAccountStatement.setInt(1, accountId);
            ResultSet accountResultSet = checkAccountStatement.executeQuery();

            if (accountResultSet.next()) {
                int userId = accountResultSet.getInt("userId");

                PreparedStatement checkUserStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
                checkUserStatement.setInt(1, userId);
                ResultSet userResultSet = checkUserStatement.executeQuery();

                if (userResultSet.next()) {
                    if (amount <= 100000000) {
                        PreparedStatement statement = connection.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
                        statement.setDouble(1, amount);
                        statement.setInt(2, accountId);
                        statement.executeUpdate();

                        PreparedStatement transactionStatement = connection.prepareStatement("INSERT INTO transactions (accountId, amount) VALUES (?, ?)");
                        transactionStatement.setInt(1, accountId);
                        transactionStatement.setDouble(2, amount);
                        transactionStatement.executeUpdate();
                    } else {
                        boolean validAmount = false;
                        while (!validAmount) {
                            try {
                                Scanner scanner = new Scanner(System.in);
                                System.out.println("The transaction size cannot exceed 100,000,000. Please enter the deposit amount:");
                                amount = scanner.nextDouble();
                                validAmount = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect amount. Please enter a number.");
                            }
                        }
                        deposit(accountId, amount);
                    }
                } else {
                    System.out.println("Invalid user ID. Want to create a new user? yes/no");

                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("Yes")) {
                        System.out.println("Enter a new username:");
                        String name = scanner.nextLine();
                        System.out.println("Enter new user address");
                        String address = scanner.nextLine();
                        registerUser(name, address);
                        deposit(accountId, amount);
                    }
                }
            } else {
                System.out.println("Invalid account ID. Want to create a new account with a different currency? Yes/no");

                Scanner scanner = new Scanner(System.in);
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("Yes")) {
                    System.out.println("Enter ID user:");
                    int userId = scanner.nextInt();
                    System.out.println("Enter opening balance:");
                    double initialBalance = scanner.nextDouble();
                    System.out.println("Enter currency:");
                    String currency = scanner.next();
                    addAccount(userId, initialBalance, currency);
                    deposit(accountId, amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void withdraw(int accountId, double amount) {
        try {
            PreparedStatement checkAccountStatement = connection.prepareStatement("SELECT * FROM accounts WHERE id = ?");
            checkAccountStatement.setInt(1, accountId);
            ResultSet accountResultSet = checkAccountStatement.executeQuery();

            if (accountResultSet.next()) {
                int userId = accountResultSet.getInt("userId");

                PreparedStatement checkUserStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
                checkUserStatement.setInt(1, userId);
                ResultSet userResultSet = checkUserStatement.executeQuery();

                if (userResultSet.next()) {
                    PreparedStatement checkBalanceStatement = connection.prepareStatement("SELECT balance FROM accounts WHERE id = ?");
                    checkBalanceStatement.setInt(1, accountId);
                    ResultSet balanceResultSet = checkBalanceStatement.executeQuery();

                    if (balanceResultSet.next()) {
                        double balance = balanceResultSet.getDouble("balance");

                        if (balance >= amount && balance - amount >= 0 && balance - amount <= 2000000000) {
                            PreparedStatement statement = connection.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
                            statement.setDouble(1, amount);
                            statement.setInt(2, accountId);
                            statement.executeUpdate();

                            PreparedStatement transactionStatement = connection.prepareStatement("INSERT INTO transactions (accountId, amount) VALUES (?, ?)");
                            transactionStatement.setInt(1, accountId);
                            transactionStatement.setDouble(2, -amount);
                            transactionStatement.executeUpdate();
                        } else {
                            System.out.println("Insufficient funds on the account or the maximum balance has been exceeded");

                            boolean validAmount = false;
                            while (!validAmount) {
                                try {
                                    Scanner scanner = new Scanner(System.in);
                                    System.out.println("Enter amount to withdraw:");
                                    amount = scanner.nextDouble();
                                    validAmount = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("Incorrect amount. Please enter a number.");
                                }
                            }

                            withdraw(accountId, amount);
                        }
                    }
                } else {
                    System.out.println("Non-existent user ID");
                }
            } else {
                System.out.println("Invalid account ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkActiveAccounts(int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM accounts WHERE userId = ?");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void deleteUser(int userId) {
        if (checkActiveAccounts(userId)) {
            System.out.println("You cannot delete a user who has active accounts");
            return;
        }

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getUserAccounts(int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM accounts WHERE userId = ?");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int accountId = resultSet.getInt("id");
                double balance = resultSet.getDouble("balance");
                String currency = resultSet.getString("currency");

                System.out.println("Account: " + accountId);
                System.out.println("Balance: " + balance);
                System.out.println("Currency: " + currency);
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(int accountId) {
        try {
            PreparedStatement checkBalanceStatement = connection.prepareStatement("SELECT balance FROM accounts WHERE id = ?");
            checkBalanceStatement.setInt(1, accountId);
            ResultSet balanceResultSet = checkBalanceStatement.executeQuery();

            if (balanceResultSet.next()) {
                double balance = balanceResultSet.getDouble("balance");

                if (balance > 0) {
                    System.out.println("You can’t delete an account that has funds, " +
                            "well, if you want, the bank will take it for itself without problems");
                    return;
                }
            }

            PreparedStatement statement = connection.prepareStatement("DELETE FROM accounts WHERE id = ?");
            statement.setInt(1, accountId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAccountExists(int accountId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM accounts WHERE id = ?");
            statement.setInt(1, accountId);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }




}

