package com.kata.bankAccount.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void new_account_should_have_zero_as_balance() {
        assertEquals(new Balance(0), new Account().balance());
    }

    @Test
    public void deposit_10_on_new_account_should_have_10_as_balance() {
        final Account newAccount = new Account();

        newAccount.deposit(new Amount(10));

        assertEquals(new Balance(10), newAccount.balance());
    }

    @Test
    public void deposit_zero_amount_should_be_blocked() {
        final Account newAccount = new Account();

        assertThrows(IllegalArgumentException.class, () -> {
            newAccount.deposit(new Amount(0));
        });
    }

    @Test
    public void deposit_negativ_amount_should_be_blocked() {
        final Account newAccount = new Account();

        assertThrows(IllegalArgumentException.class, () -> {
            newAccount.deposit(new Amount(-10));
        });
    }

    @Test
    public void withdrawal_10_should_give_10_when_balance_is_ok() {
        final Account newAccount = new Account();

        newAccount.deposit(new Amount(100));

        assertEquals(new Amount(10), newAccount.withdrawal(new Amount(10)));
        assertEquals(new Balance(90), newAccount.balance());
    }
}
