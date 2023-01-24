package com.kata.bankAccount.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@EqualsAndHashCode
@ToString
public class Amount {

    @Getter
    final BigDecimal value;

    public Amount(final BigDecimal value) {
        this.value = value;
    }

    public Amount(final int valueInInt) {
        this(new BigDecimal(valueInInt));
    }
}
