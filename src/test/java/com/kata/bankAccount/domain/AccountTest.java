package com.kata.bankAccount.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void new_account_should_have_zero_as_balance() {
        assertEquals(BigDecimal.ZERO, new Account().balance());
    }

    @Test
    public void deposit_10_on_new_account_should_have_10_as_balance() {
        final Account newAccount = new Account();

        newAccount.deposit(amount10());

        assertEquals(BigDecimal.TEN, newAccount.balance());
    }

    @Test
    public void deposit_zero_amount_should_be_blocked() {
        final Account newAccount = new Account();

        assertThrows(IllegalArgumentException.class, () -> {
            newAccount.deposit(amount0());
        });
    }

    @Test
    public void deposit_negativ_amount_should_be_blocked() {
        final Account newAccount = new Account();

        assertThrows(IllegalArgumentException.class, () -> {
            newAccount.deposit(new Amount(new BigDecimal(-10)));
        });
    }

    private Amount amount0() {
        return new Amount(BigDecimal.ZERO);
    }

    private Amount amount10() {
        return new Amount(BigDecimal.TEN);
    }
}
