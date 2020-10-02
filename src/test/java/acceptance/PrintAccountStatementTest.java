package acceptance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import treatment.Account;
import treatment.Console;
import treatment.TransactionRepository;

import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class PrintAccountStatementTest {

    @Mock
    Console console;
    private Account account;

    @Before
    public void setUp() {
        TransactionRepository transactionRepository=new TransactionRepository();
        account = new Account(transactionRepository);
    }

    @Test
    public void printingStatementIncludingDepositAndWithdrawal() {

        account.deposit(500);
        account.deposit(2000);
        account.withdraw(700);
        account.printStatement();

        InOrder inorder = inOrder(console);
        inorder.verify(console).printLine("Date || Credit || Debit || Balance");
        inorder.verify(console).printLine("15/01/2020 || 700.00 || 1800.00");
        inorder.verify(console).printLine("10/01/2020 || 2000.00 || || 2500.00");
        inorder.verify(console).printLine("05/01/2020 || 500.00 || || 500.00");


    }
}
