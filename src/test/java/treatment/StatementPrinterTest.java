package treatment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {

    @Mock
    Console console;
    private static final List<Transaction> NO_TRANSACTIONS = Collections.EMPTY_LIST;
    public static final String HEADER = "Date || Credit || Debit || Balance";

    @Test
    public void statementPrinterShouldAlwaysPrintTheHeader() {

        StatementPrinter statementPrinter = new StatementPrinter(console);
        statementPrinter.print(NO_TRANSACTIONS);
        verify(console).printLine(HEADER);
    }

    @Test
    public void statementPrinterShouldPrintDepositTransactionInCredit() {
        Transaction deposit1 = new Transaction("15/01/2020", 700);
        Transaction deposit2 = new Transaction("15/01/2020", 700);
        List<Transaction> transactions = Arrays.asList(deposit1, deposit2);

        StatementPrinter statementPrinter = new StatementPrinter(console);
        statementPrinter.print(transactions);

        verify(console).printLine(HEADER);
        verify(console).printLine("15/01/2020 || 700.00 || || 1400.00");
        verify(console).printLine("15/01/2020 || 700.00 || || 700.00");
    }

    @Test
    public void statementPrinterShouldPrintWithdrawTransactionInDebit() {
        Transaction debit1 = new Transaction("15/01/2020", -700);
        Transaction debit2 = new Transaction("15/01/2020", -700);
        List<Transaction> transactions = Arrays.asList(debit1, debit2);

        StatementPrinter statementPrinter = new StatementPrinter(console);
        statementPrinter.print(transactions);

        verify(console).printLine(HEADER);
        verify(console).printLine("15/01/2020 || || -700.00 || -1400.00");
        verify(console).printLine("15/01/2020 || || -700.00 || -700.00");
    }


}
