package treatment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {

    @Mock
    Console console;
    private static final List<Transaction> NO_TRANSACTIONS = null;
    public static final String HEADER = "Date || Credit || Debit || Balance";

    @Test
    public void statementPrinterShouldAlwaysPrintTheHeader() {

        StatementPrinter statementPrinter = new StatementPrinter(console);
        statementPrinter.print(NO_TRANSACTIONS);
        verify(console).printLine(HEADER);
    }
}
