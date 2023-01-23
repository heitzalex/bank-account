package com.kata.bankAccount.domain;

import java.math.BigDecimal;

public class Account {

    private Balance balance = new Balance(BigDecimal.ZERO);

    public BigDecimal balance() {
        return balance.balance();
    }

    public void deposit(final Amount amount) {
        if (isNegativOrZeroAmount(amount)) {
            throw new IllegalArgumentException("Impossible to deposit a negative or zero amount.");
        }

        balance = balance.add(amount);
    }

    private static boolean isNegativOrZeroAmount(Amount amount) {
        return amount.value.compareTo(BigDecimal.ZERO) <= 0;
    }
}
