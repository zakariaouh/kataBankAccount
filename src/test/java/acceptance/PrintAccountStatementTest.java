package acceptance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import treatment.*;

import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class PrintAccountStatementTest {

    @Mock
    Console console;
    @Mock
    Clock clock;
    private Account account;

    @Before
    public void setUp() {
        TransactionRepository transactionRepository=new TransactionRepository(clock);
        StatementPrinter statementPrinter =new StatementPrinter(console);
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void printingStatementIncludingDepositAndWithdrawal() {
      //TODO given(clock.currentDay()).willReturn(a day)
        account.deposit(500);
        account.deposit(2000);
        account.withdraw(700);
        account.printStatement();

        InOrder inorder = inOrder(console);
        inorder.verify(console).printLine("Date || Credit || Debit || Balance");
        inorder.verify(console).printLine("15/01/2020 || || -700.00 || 1800.00");
        inorder.verify(console).printLine("10/01/2020 || 2000.00 || || 2500.00");
        inorder.verify(console).printLine("05/01/2020 || 500.00 || || 500.00");


    }
}
