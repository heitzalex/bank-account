package com.kata.bankAccount.domain;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode
public class Balance {

    final BigDecimal value;

    public Balance(final BigDecimal value) {
        this.value = value;
    }

    public Balance(final int valueInInt) {
        this(new BigDecimal(valueInInt));
    }

    public Balance add(final Amount amountToAdd) {
        return new Balance(value.add(amountToAdd.value));
    }

    public Balance substract(final Amount amountToSubstract) {
        return new Balance(value.subtract(amountToSubstract.value));
    }
}
