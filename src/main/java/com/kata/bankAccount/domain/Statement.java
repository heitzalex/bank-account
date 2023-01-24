package com.kata.bankAccount.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Statement {

    @Getter
    final List<StatementLine> listeStatementLine = new ArrayList<>();

    public void addOperationHistory(final Operation operation, final Amount amount, final Balance balance) {
        final StatementLine lineToAdd = new StatementLine(operation, amount, balance);
        listeStatementLine.add(lineToAdd);
    }
}
