package com.swsa.repository;
import com.swsa.model.Customer;
import com.swsa.service.ConnectionService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public List<Customer> retrieveCustomer()

    {             //Customer customer = null;
        List<Customer> customers = new ArrayList<>();
        // Use the connection to execute SQL queries and interact with the database
        try {
            this.initConnection();
            // Your database operations here...
            Statement statement= connection.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
            // Iterate over the result set
            while (resultSet.next()) {

               int customerId = resultSet.getInt("customerId");
                String name = resultSet.getString("name");
                long mobileNo=resultSet.getLong("mobileNo");
                String address = resultSet.getString("address");
                String emailId = resultSet.getString("emailId");
                long aadhaarNo = resultSet.getLong("aadhaarNo");
                // Do something with the data, e.g., print it

               Customer customer = new Customer(customerId, name, mobileNo, address, emailId, aadhaarNo);

                customers.add(customer);
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
        return customers;
    }


    // Method to update user data into the database
    public boolean insertCustomer(Customer customer) throws SQLException {
        this.initConnection();
        String query = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection. prepareStatement(query)) {

            preparedStatement.setInt(1, customer.getCustomerId());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setLong(3,customer.getMobileNo());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5,customer.getEmailId());
            preparedStatement.setLong(6,customer.getAadhaarNo());

            System.out.println("insert Customer data successfully .. : " + customer);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Customer retrieveCustomer(int customerId)
    {
        Customer   customer = null;
        // Use the connection to execute SQL queries and interact with the database
        try {
            this.initConnection();
            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer where customerId = " + customerId);
            // Iterate over the result set
            while (resultSet.next()) {
                int Id = resultSet.getInt("customerId");
                String name = resultSet.getString("name");
                long mobileNo=resultSet.getLong("mobileNo");
                String address = resultSet.getString("address");
                String emailId = resultSet.getString("emailId");
                long aadhaarNo = resultSet.getLong("aadhaarNo");
                // Do something with the data, e.g., print it

                 customer = new Customer(Id, name, mobileNo, address, emailId, aadhaarNo);

               // customers.add(customer);

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
        return  customer;
    }






    // Method to update user data into the database
    public boolean updateNewCustomer(Customer customer) throws SQLException {
        this.initConnection();

        String query = "UPDATE customer SET  customerId= ?,Name= ?, MobileNo = ?,Address=?,EmailId= ?,AadhaarNo=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setInt(1, customer.getCustomerId());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setLong(3,customer.getMobileNo());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5,customer.getEmailId());
            preparedStatement.setLong(6,customer.getAadhaarNo());

            System.out.println("Update Customer data successfully .. : " + customer);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to delete user data into the database
    public boolean deleteNewCustomer(int customerId) throws SQLException {
        this.initConnection();

        String query = "DELETE FROM customer WHERE customerId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1,customerId);

            System.out.println("deleting saving account Successfully..: " + customerId);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


