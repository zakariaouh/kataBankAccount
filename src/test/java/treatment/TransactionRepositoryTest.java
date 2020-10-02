package treatment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {
    @Mock
    Clock clock;
    private static final int ANY_AMOUNT = 500;
    private static final String TODAY = "20/11/2020";
    private TransactionRepository transactionRepository;

    @Before
    public void setUp() {
        transactionRepository = new TransactionRepository(clock);
    }

    @Test
    public void transactionRepositoryShouldRecordTransaction() {
        given(clock.currentDay()).willReturn(TODAY);

        transactionRepository.recode(ANY_AMOUNT);

        List<Transaction> allTransaction = transactionRepository.getAllTransaction();
        assertThat(allTransaction.size(), is(1));
        assertThat(allTransaction.get(0), is(new Transaction(TODAY, ANY_AMOUNT)));
    }
}
