package com.kata.bankAccount.domain;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance = new BigDecimal(0);

    public BigDecimal balance() {
        return balance;
    }
}
