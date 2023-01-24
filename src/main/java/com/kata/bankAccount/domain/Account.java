package com.kata.bankAccount.domain;

import java.math.BigDecimal;

public class Account {

    private Balance balance = new Balance(BigDecimal.ZERO);

    private Statement statement = new Statement();

    public Balance balance() {
        return balance;
    }

    public void deposit(final Amount amount) {
        if (isNegativOrZeroAmount(amount)) {
            throw new IllegalArgumentException("Impossible to deposit a negative or zero amount.");
        }

        balance = balance.add(amount);

        statement.addOperationHistory(Operation.DEPOSIT, amount, balance);
    }

    public Amount withdrawal(final Amount amount) {
        if (isWithdrawalMoreThanBalanceAccount(amount)) {
            throw new IllegalArgumentException("Impossible to withdrawal more than de balance in the account.");
        }

        balance = balance.substract(amount);

        statement.addOperationHistory(Operation.WITHDRAWAL, amount, balance);

        return amount;
    }

    private static boolean isNegativOrZeroAmount(final Amount amount) {
        return amount.value.compareTo(BigDecimal.ZERO) <= 0;
    }

    private boolean isWithdrawalMoreThanBalanceAccount(final Amount amount) {
        return amount.value.compareTo(balance.value) > 0;
    }

    public Amount withdrawalAll() {
        if (hasNoBalanceOnAccount()) {
            throw new IllegalArgumentException("Impossible to withdrawal when there is no balance on the account.");
        }

        return new Amount(balance.value);
    }

    private boolean hasNoBalanceOnAccount() {
        return balance.value.compareTo(BigDecimal.ZERO) == 0;
    }

    public void printStatement(final StatementPrinter printer) {
        printer.print(statement);
    }
}
