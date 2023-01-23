package com.kata.bankAccount.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {

    @Test
    public void newAccountShouldHaveZeroAsBalance() {
        Assertions.assertEquals(new BigDecimal(0), new Account().balance());
    }
}
