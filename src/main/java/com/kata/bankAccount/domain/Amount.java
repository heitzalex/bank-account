package com.kata.bankAccount.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@EqualsAndHashCode
public class Amount {

    @Getter
    final BigDecimal value;

    public Amount(final BigDecimal value) {
        this.value = value;
    }
}
