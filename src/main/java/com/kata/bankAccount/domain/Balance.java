package com.kata.bankAccount.domain;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode
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

    public Balance substract(final Amount amountToSubstract) {
        return new Balance(balance.subtract(amountToSubstract.value));
    }
}
