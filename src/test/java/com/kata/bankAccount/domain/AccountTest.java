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

    @Test
    public void withdrawal_20_when_balance_is_10_should_be_blocked() {
        final Account newAccount = new Account();
        newAccount.deposit(new Amount(10));


        assertThrows(IllegalArgumentException.class, () -> {
            newAccount.withdrawal(new Amount(20));
        });
        assertEquals(new Balance(10), newAccount.balance());
    }

    @Test
    public void withdrawal_all_balance_should_give_all_balance() {
        final Account newAccount = new Account();
        newAccount.deposit(new Amount(50));

        final Amount withdrawalAmount = newAccount.withdrawalAll();

        assertEquals(new Amount(50), withdrawalAmount);
    }

    @Test
    public void withdrawal_all_when_balance_is_empty_should_be_blocked() {
        final Account newAccount = new Account();

        assertThrows(IllegalArgumentException.class, () -> {
            newAccount.withdrawalAll();
        });
    }
}
