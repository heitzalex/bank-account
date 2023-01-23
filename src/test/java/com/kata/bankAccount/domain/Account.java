package com.kata.bankAccount.domain;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance = new BigDecimal(0);

    public BigDecimal balance() {
        return balance;
    }

    public void deposit(final BigDecimal amount) {
        if (amount.compareTo(new BigDecimal(0)) <= 0) {
            throw new IllegalArgumentException("Impossible to deposit a negative or zero amount.");
        }

        balance = balance.add(amount);
    }
}
