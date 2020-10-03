package treatment;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {
    private Console console;
    public static final String HEADER = "Date || Credit || Debit || Balance";


    public StatementPrinter(Console console) {

        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(HEADER);
        AtomicInteger runningBalance = new AtomicInteger(0);
        List<StatementLine> statementLines = transactions.stream()
                .map(transaction -> statementLine(transaction, runningBalance))
                .collect(Collectors.toList());
        statementLines.forEach(statementLine -> console.printLine(statementLine.format()));
    }

    private StatementLine statementLine(Transaction transaction, AtomicInteger runningBalance) {
        return new StatementLine(transaction, runningBalance.addAndGet(transaction.amount()));
    }




}
