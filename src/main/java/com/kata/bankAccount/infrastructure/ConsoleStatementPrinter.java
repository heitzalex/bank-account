package com.kata.bankAccount.infrastructure;

import com.kata.bankAccount.domain.Statement;
import com.kata.bankAccount.domain.StatementPrinter;

public class ConsoleStatementPrinter implements StatementPrinter {

    @Override
    public void print(final Statement statementToPrint) {
        System.out.println(statementToPrint.getListeStatementLine());
    }
}
