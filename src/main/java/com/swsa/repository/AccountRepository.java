package com.swsa.repository;
import com.swsa.model.Account;
import com.swsa.service.ConnectionService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public Account retrieveAccount(String accountNumber) {
        return null;
    }

    public List<Account> retrieveAccount() {
        List<Account> accounts = new ArrayList<>();
        // Use the connection to execute SQL queries and interact with the database
        try {
            this.initConnection();
            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
            // Iterate over the result set
            while (resultSet.next()) {
                String accountNumber = resultSet.getString("AccountNumber");
                String accountHolderName = resultSet.getString("AccountHolderName");
                double balance = resultSet.getLong("balance");
                int customerId = resultSet.getInt("customerId");

                // Do something with the data, e.g., print it
                Account account = new Account(accountNumber,accountHolderName,balance,customerId);
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close the connection when done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return accounts;
    }


    // Method to update user data into the database
    public boolean insertAccount(Account account) throws SQLException {
        this.initConnection();
        //   int amount = 0;
        String query = "INSERT INTO account VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountHolderName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setInt(4, account.getCustomerId());
            System.out.println("Account created  data successfully .. : " + account);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to update user data into the database
    public boolean updateAccount(Account account) throws SQLException {
        this.initConnection();

        String query = "UPDATE account SET   AccountNumber= ?, AccountHolderName= ?, Balance= ?, CustomerId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountHolderName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setInt(4, account.getCustomerId());


            System.out.println("updating  Account data to table: " + account);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
//============================================================================
    //---------------DEPOSIT ACOUNT-----------------------------
//=============================================================================


    // Method to update user data into the database
    public boolean deposit(Account account) throws SQLException {
        this.initConnection();
        int amount = 0;
        String query = "INSERT INTO account VALUES (?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountHolderName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setInt(4, account.getCustomerId());

            System.out.println("Deposit Money successfully .... : " + account);

            int rowsInserted = preparedStatement.executeUpdate();
            if (amount > 0) {
                account.setBalance(account.getBalance() + amount);
                System.out.println("Deposited $" + amount + " into account " + account.getAccountNumber());
            } else {
                System.out.println("Deposit amount must be positive.");
            }
            return rowsInserted > 0;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to update user data into the database
    public boolean updatedeposit(Account account) throws SQLException {
        this.initConnection();
        String query = "UPDATE account  SET   AccountNumber= ?,AccountHolderName(),Balance = Amount +  ?, CustomerId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountHolderName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setInt(4, account.getCustomerId());

            System.out.println("updating  Deposit Money Account data to table: " + account);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    // ================================================================
    //  ---------------Withdraw Amount -----------------------------
    // ====================================================================


    // Method to update user data into the database

    public boolean withdraw(Account account) throws SQLException {
        this.initConnection();
        int amount = 0;
        String query = "INSERT INTO account VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountHolderName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setInt(4, account.getCustomerId());
            System.out.println("  Account created  data successfully .. : " + account);

            System.out.println("Withdraw Amount successfully .. : " + account);

            if (amount > 0 && account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                System.out.println("Withdrew $" + amount + " from account " + account.getAccountNumber());
            } else if (amount > 0 && account.getBalance() < amount) {
                System.out.println("Insufficient funds for withdrawal.");
            } else {
                System.out.println("Withdrawal amount must be positive.");
            }
            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    // Method to update user data into the database

    public boolean updatewithdraw(Account account) throws SQLException {
        this.initConnection();
        String query = "UPDATE account  SET   AccountNumber= ?, AccountHolderName(),Balance = Amount -  ?, CustomerId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountHolderName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setDouble(4, account.getCustomerId());

            System.out.println("Withdraw Money Sucessfully........: " + account);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


//=====================================================
//----------------CHECK BALANCE-------------
//===========================================================
    String url = "jdbc:mysql://localhost:3306/bankmanagementsystems";
    String username = "root";
    String password = "Prakash@123";
    public double checkBalance(String accountNumber)  {
        double balance = 0.0;
        String query = "SELECT balance FROM account WHERE accountNumber = ?";
        try (Connection conn = DriverManager.getConnection(url,username,password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, accountNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    balance =rs.getDouble("balance");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }

}