package com.swsa.service;
import com.swsa.repository.AccountRepository;

public class CheckBalanceOperationService
{

        private static final AccountRepository ACCOUNT_REPOSITORY = new AccountRepository();

        public double checkBalance(String accountNumber) {
        return ACCOUNT_REPOSITORY.checkBalance(accountNumber);
}
}

