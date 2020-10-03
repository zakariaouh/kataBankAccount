package treatment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    private Account account;
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    StatementPrinter statementPrinter;
    private final int ANY_AMOUNT = 500;

    @Before
    public void setUp() {
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void accountDepositShouldRecordATransactionWithTheSameAmount() {
        account.deposit(ANY_AMOUNT);
        verify(transactionRepository).recode(ANY_AMOUNT);

    }

    @Test
    public void accountWithdrawShouldRecordATransactionWithTheMinusAmount() {
        account.withdraw(ANY_AMOUNT);
        verify(transactionRepository).recode(-ANY_AMOUNT);

    }

    @Test
    public void accountPrintStatementShouldCallThePrinterWithAllAccountTransactions() {
        List<Transaction> transactions = Collections.singletonList(new Transaction(null, 100));
        given(transactionRepository.getAllTransaction()).willReturn(transactions);
        account.printStatement();
        verify(statementPrinter).print(transactions);

    }
}
