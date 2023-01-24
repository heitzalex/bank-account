package com.kata.bankAccount.infrastructure;

import com.kata.bankAccount.domain.Statement;
import com.kata.bankAccount.domain.StatementLine;
import com.kata.bankAccount.domain.StatementPrinter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TestStatementPrinter implements StatementPrinter {

    @Getter
    final List<StatementLine> listeStatementLineToPrint = new ArrayList<>();

    @Override
    public void print(final Statement statementToPrint) {
        listeStatementLineToPrint.addAll(statementToPrint.getListeStatementLine());
    }
}
