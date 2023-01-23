package com.kata.bankAccount.domain;

import lombok.Getter;

import java.math.BigDecimal;

public class Amount {

    @Getter
    final BigDecimal value;

    public Amount(final BigDecimal value) {
        this.value = value;
    }
}
