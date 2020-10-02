package treatment;

import java.util.List;

public class StatementPrinter {
    private Console console;
    public static final String HEADER = "Date || Credit || Debit || Balance";
    public StatementPrinter(Console console) {

        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(HEADER);

    }
}
