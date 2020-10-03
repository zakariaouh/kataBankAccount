package treatment;

import mockito.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StatementPrinterTest {

    @Mock
    Console console;
    private static final List<Transaction> NO_TRANSACTIONS = Collections.emptyList();
    public static final String HEADER = "Date || Credit || Debit || Balance";
    private StatementPrinter statementPrinter;

    @BeforeEach
    public void setUp() {
        statementPrinter = new StatementPrinter(console);
    }

    @Test
    void itShouldAlwaysPrintTheHeader() {

        statementPrinter.print(NO_TRANSACTIONS);
        verify(console).printLine(HEADER);
    }

    @Test
    void itShouldPrintDepositTransactionInCredit() {
        Transaction deposit1 = new Transaction("15/01/2020", new BigDecimal(700));
        Transaction deposit2 = new Transaction("15/01/2020", new BigDecimal(700));
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
    void itrShouldPrintWithdrawTransactionInDebit() {
        Transaction debit1 = new Transaction("15/01/2020", new BigDecimal(-700));
        Transaction debit2 = new Transaction("15/01/2020", new BigDecimal(-700));
        List<Transaction> transactions = Arrays.asList(debit1, debit2);

        statementPrinter.print(transactions);

        verify(console).printLine(HEADER);
        verify(console).printLine("15/01/2020 || || -700.00 || -1400.00");
        verify(console).printLine("15/01/2020 || || -700.00 || -700.00");
    }

    @Test
    void itShouldPrintTransactionsInReverseChronologicalOrder() {
        Transaction debit1 = new Transaction("15/01/2020", new BigDecimal(1000));
        Transaction credit = new Transaction("17/01/2020", new BigDecimal(-500));
        Transaction debit2 = new Transaction("18/01/2020", new BigDecimal(700));
        List<Transaction> transactions = Arrays.asList(credit, debit1, debit2);


        statementPrinter.print(transactions);

        InOrder inorder = inOrder(console);
        inorder.verify(console).printLine(HEADER);
        inorder.verify(console).printLine("18/01/2020 || 700.00 || || 1200.00");
        inorder.verify(console).printLine("17/01/2020 || || -500.00 || 500.00");
        inorder.verify(console).printLine("15/01/2020 || 1000.00 || || 1000.00");
    }
}


