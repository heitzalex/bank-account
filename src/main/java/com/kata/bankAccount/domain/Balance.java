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
        final BigDecimal resultingValue = value.add(amountToAdd.value);
        return new Balance(resultingValue);
    }

    public Balance substract(final Amount amountToSubstract) {
        final BigDecimal resultingValue = value.subtract(amountToSubstract.value);
        return new Balance(resultingValue);
    }
}
