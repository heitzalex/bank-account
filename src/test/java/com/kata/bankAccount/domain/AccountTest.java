package com.kata.bankAccount.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void new_account_should_have_zero_as_balance() {
        assertEquals(new BigDecimal(0), new Account().balance());
    }

    @Test
    public void deposit_10_on_new_account_should_have_10_as_balance() {
        final Account newAccount = new Account();

        newAccount.deposit(new BigDecimal(10));

        assertEquals(new BigDecimal(10), newAccount.balance());
    }

    @Test
    public void deposit_zero_amount_should_be_blocked() {
        final Account newAccount = new Account();

        assertThrows(IllegalArgumentException.class, () -> {
            newAccount.deposit(new BigDecimal(0));
        });
    }

    @Test
    public void deposit_negativ_amount_should_be_blocked() {
        final Account newAccount = new Account();

        assertThrows(IllegalArgumentException.class, () -> {
            newAccount.deposit(new BigDecimal(-10));
        });
    }
}
