package com.swsa.service;
import com.swsa.model.Customer;
import com.swsa.repository.CustomerRepository;
import java.sql.SQLException;
import java.util.List;
public class CustomerService {

    private static final CustomerRepository CUSTOMER_REPOSITORY = new CustomerRepository();

    public boolean insertCustomer(Customer customer)throws SQLException {
        if (CUSTOMER_REPOSITORY.insertCustomer(customer)) {
            System.out.println("Customer inserted successfully!");
        } else {
            System.out.println("Failed to insert Customer.");
            return false;
        }
        return true;

    }


    public List<Customer> retrieveCustomer() {
        return CUSTOMER_REPOSITORY.retrieveCustomer();

    }
}




