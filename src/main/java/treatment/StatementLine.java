package treatment;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class StatementLine {
    private DecimalFormat decimalFormatter = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));
    private Transaction transaction;
    private int balance;

    public StatementLine(Transaction transaction, int balance) {

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
