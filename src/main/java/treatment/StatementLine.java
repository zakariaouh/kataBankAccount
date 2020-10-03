package treatment;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class StatementLine {
    private final DecimalFormat decimalFormatter = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));
    private final Transaction transaction;
    private final BigDecimal balance;

    public StatementLine(Transaction transaction, BigDecimal balance) {

        this.transaction = transaction;
        this.balance = balance;
    }

    public String format() {
        String lineToPrint = "";
        if (transaction.isDebit()) {
            lineToPrint = transaction.date()
                    + " || "
                    + decimalFormatter.format(transaction.amount())
                    + " || || "
                    + decimalFormatter.format(balance);
        }
        if (transaction.isCredit()) {
            lineToPrint = transaction.date()
                    + " || || "
                    + decimalFormatter.format(transaction.amount())
                    + " || "
                    + decimalFormatter.format(balance);
        }
        return lineToPrint;
    }
}
