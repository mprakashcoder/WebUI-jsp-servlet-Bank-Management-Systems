package com.swsa.service;
import com.swsa.model.Account;
import com.swsa.repository.AccountRepository;
import java.sql.SQLException;

public class AccountDepositOperationService {

    private static final AccountRepository ACCOUNT_REPOSITORY = new AccountRepository();

    //==================Deposit================================

    public boolean deposit(Account account)throws SQLException {
        if (ACCOUNT_REPOSITORY.deposit(account)) {
            System.out.println("deposit inserted successfully!");
        } else {
            System.out.println("Failed to insert deposit.");
            return false;
        }
        return true;

    }

}
