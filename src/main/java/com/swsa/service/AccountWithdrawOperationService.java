package com.swsa.service;
import com.swsa.model.Account;
import com.swsa.repository.AccountRepository;
import java.sql.SQLException;
public class AccountWithdrawOperationService
{ private static final AccountRepository ACCOUNT_REPOSITORY = new AccountRepository();

//===================Withdraw Amount =================================

    public boolean withdraw(Account account)throws SQLException {
        if (ACCOUNT_REPOSITORY.withdraw(account)) {
            System.out.println("withdraw Money inserted successfully!");
        } else {
            System.out.println("Failed to  withdraw Money.");
            return false;
        }
        return true;

    }

    }


