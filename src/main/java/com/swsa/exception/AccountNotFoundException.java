package com.swsa.exception;

public  class AccountNotFoundException  extends RuntimeException {
    public AccountNotFoundException (int accountNo) {
        super("accountNo Not Found " + accountNo);
    }
}

