package com.kata.bankAccount.domain;

import java.math.BigDecimal;

public class Account {

    private Balance balance = new Balance(BigDecimal.ZERO);

    public Balance balance() {
        return balance;
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

    public Amount withdrawal(final Amount amount) {
        balance = balance.substract(amount);

        return amount;
    }
}
