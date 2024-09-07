package com.swsa.model;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    String accountNumber;
    String accountHolderName;
    double balance;
    int customerId;

    public Account(String accountNumber) {
    }

    public void getCustomerId(String customerId) {
    }
}













