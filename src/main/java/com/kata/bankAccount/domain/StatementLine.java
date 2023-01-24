package com.kata.bankAccount.domain;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
public class StatementLine {

    final private Operation operation;

    final private LocalDateTime date;

    final private Amount amount;

    final private Balance balance;

    public StatementLine(final Operation operation, final Amount amountOperation, final Balance balanceOperation) {
        this.date = LocalDateTime.now();
        this.operation = operation;
        this.amount = amountOperation;
        this.balance = balanceOperation;
    }
}
