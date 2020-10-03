package treatment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {

    @Mock
    Console console;
    private static final List NO_TRANSACTIONS = Collections.EMPTY_LIST;
    public static final String HEADER = "Date || Credit || Debit || Balance";
    private StatementPrinter statementPrinter;

    @Before
    public void setUp(){
         statementPrinter = new StatementPrinter(console);
    }

    @Test
    public void itShouldAlwaysPrintTheHeader() {

        statementPrinter.print(NO_TRANSACTIONS);
        verify(console).printLine(HEADER);
    }

    @Test
    public void itShouldPrintDepositTransactionInCredit() {
        Transaction deposit1 = new Transaction("15/01/2020", 700);
        Transaction deposit2 = new Transaction("15/01/2020", 700);
        List<Transaction> transactions = Arrays.asList(deposit1, deposit2);

        StatementPrinter statementPrinter = getStatementPrinter();
        statementPrinter.print(transactions);

        verify(console).printLine(HEADER);
        verify(console).printLine("15/01/2020 || 700.00 || || 1400.00");
        verify(console).printLine("15/01/2020 || 700.00 || || 700.00");
    }

    private StatementPrinter getStatementPrinter() {
        return new StatementPrinter(console);
    }

    @Test
    public void itrShouldPrintWithdrawTransactionInDebit() {
        Transaction debit1 = new Transaction("15/01/2020", -700);
        Transaction debit2 = new Transaction("15/01/2020", -700);
        List<Transaction> transactions = Arrays.asList(debit1, debit2);

        statementPrinter.print(transactions);

        verify(console).printLine(HEADER);
        verify(console).printLine("15/01/2020 || || -700.00 || -1400.00");
        verify(console).printLine("15/01/2020 || || -700.00 || -700.00");
    }

    @Test
    public void itShouldPrintTransactionsInReverseChronologicalOrder() {
        Transaction debit1 = new Transaction("15/01/2020", 1000);
        Transaction credit = new Transaction("17/01/2020", -500);
        Transaction debit2 = new Transaction("18/01/2020", 700);
        List<Transaction> transactions = Arrays.asList(credit,debit1,debit2);

       
        statementPrinter.print(transactions);

        InOrder inorder = inOrder(console);
        inorder.verify(console).printLine(HEADER);
        inorder.verify(console).printLine("18/01/2020 || 700.00 || || 1200.00");
        inorder.verify(console).printLine("17/01/2020 || || -500.00 || 500.00");
        inorder.verify(console).printLine("15/01/2020 || 1000.00 || || 1000.00");
    }
}
