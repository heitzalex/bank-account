package com.kata.bankAccount.domain;

import java.math.BigDecimal;

public class Balance {

    final BigDecimal balance;

    public Balance(final BigDecimal value) {
        this.balance = value;
    }

    public BigDecimal balance() {
        return balance;
    }

    public Balance add(final Amount amountToAdd) {
        return new Balance(balance.add(amountToAdd.value));
    }
}
