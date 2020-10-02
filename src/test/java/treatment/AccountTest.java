package treatment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    private Account account;
    @Mock
    TransactionRepository transactionRepository;
    private int ANY_AMOUNT = 500;

    @Before
    public void setUp()  {
        account = new Account(transactionRepository);
    }

    @Test
    public void accountDepositShouldRecordATransactionWithTheSameAmount() {

        account.deposit(ANY_AMOUNT);
        verify(transactionRepository).recode(ANY_AMOUNT);

    }
}
