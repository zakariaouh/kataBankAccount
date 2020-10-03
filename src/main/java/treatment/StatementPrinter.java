package treatment;

import javafx.beans.binding.Bindings;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {
    private Console console;
    public static final String HEADER = "Date || Credit || Debit || Balance";

    private DecimalFormat decimalFormatter = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));


    public StatementPrinter(Console console) {

        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(HEADER);
        AtomicInteger runningBalance = new AtomicInteger(0);
        List<String> statmentLines = transactions.stream()
                .map(transaction -> statementLine(transaction, runningBalance))
                .collect(Collectors.toList());
        statmentLines.forEach(statementLine -> console.printLine(statementLine));
    }

    private String statementLine(Transaction transaction, AtomicInteger runningBalance) {
        return transaction.date()
                + " || "
                + decimalFormatter.format(transaction.amount())
                + " || || "
                + decimalFormatter.format(runningBalance.addAndGet(transaction.amount()));
    }


}
