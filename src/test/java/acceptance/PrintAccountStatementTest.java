package acceptance;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import treatment.*;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
class PrintAccountStatementTest {

    @Mock
    Console console;
    @Mock
    Clock clock;
    private Account account;

    @BeforeEach
    public void setUp() {
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    void printingStatementIncludingDepositAndWithdrawal() {
        given(clock.currentDayAsString()).willReturn("05/01/2020", "10/01/2020", "15/01/2020");

        account.deposit(new BigDecimal(500));
        account.deposit(new BigDecimal(2000));
        account.withdraw(new BigDecimal(700));
        account.printStatement();

        InOrder inorder = inOrder(console);
        inorder.verify(console).printLine("Date || Credit || Debit || Balance");
        inorder.verify(console).printLine("15/01/2020 || || -700.00 || 1800.00");
        inorder.verify(console).printLine("10/01/2020 || 2000.00 || || 2500.00");
        inorder.verify(console).printLine("05/01/2020 || 500.00 || || 500.00");


    }
}
