package treatment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {
    private final Console console;
    public static final String HEADER = "Date || Credit || Debit || Balance";


    public StatementPrinter(Console console) {

        this.console = console;
    }

    public void print(List<Transaction> transactions) {


        List<Transaction> sortedTransactions = sortTransactionsInChronologicalOrder(transactions);

        List<StatementLine> statementLines = getStatementLines(sortedTransactions);

        printTransactionsInReverseChronologicalOrder(statementLines);

    }

    private List<Transaction> sortTransactionsInChronologicalOrder(List<Transaction> transactions) {
        List<Transaction> copyOfTransactions = new ArrayList<>(transactions);
        copyOfTransactions.sort(new TransactionDateComparator());
        return copyOfTransactions;
    }

    private void printTransactionsInReverseChronologicalOrder(List<StatementLine> statementLines) {
        Collections.reverse(statementLines);
        printStatementLines(statementLines);
    }

    private void printStatementLines(List<StatementLine> statementLines) {
        console.printLine(HEADER);
        statementLines.forEach(statementLine -> console.printLine(statementLine.format()));
    }


    private List<StatementLine> getStatementLines(List<Transaction> transactions) {
        AtomicInteger runningBalance = new AtomicInteger(0);
        return transactions.stream()
                .map(transaction -> statementLine(transaction, runningBalance))
                .collect(Collectors.toList());

    }

    private StatementLine statementLine(Transaction transaction, AtomicInteger runningBalance) {
        return new StatementLine(transaction, runningBalance.addAndGet(transaction.amount()));
    }


}
