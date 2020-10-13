package treatment.statment;

import treatment.tools.AmountParser;
import treatment.tools.Clock;
import treatment.transactions.Transaction;

import java.math.BigDecimal;

public class StatementLine {

    private final Transaction transaction;
    private final BigDecimal balance;

    public StatementLine(Transaction transaction, BigDecimal balance) {

        this.transaction = transaction;
        this.balance = balance;
    }

    public String format() {
        String lineToPrint = "";
        if (transaction.isDebit()) {
            lineToPrint = Clock.getDateAsString(transaction.date())
                    + " || "
                    + AmountParser.pars(transaction.amount())
                    + " || || "
                    + AmountParser.pars(balance);
        }
        if (transaction.isCredit()) {
            lineToPrint = Clock.getDateAsString(transaction.date())
                    + " || || "
                    + AmountParser.pars(transaction.amount())
                    + " || "
                    + AmountParser.pars(balance);
        }
        return lineToPrint;
    }
}
