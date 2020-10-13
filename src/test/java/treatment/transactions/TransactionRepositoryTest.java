package treatment.transactions;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import treatment.tools.Clock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryTest {
    @Mock
    Clock clock;
    private static final BigDecimal ANY_AMOUNT = new BigDecimal(500);
    private static final LocalDate TODAY = LocalDate.of(2020,11,20);
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {
        transactionRepository = new TransactionRepository(clock);
    }

    @Test
    void transactionRepositoryShouldRecordTransaction() {
        given(clock.today()).willReturn(TODAY);

        transactionRepository.record(ANY_AMOUNT);

        List<Transaction> allTransaction = transactionRepository.getAllTransaction();
        Assertions.assertEquals(1, allTransaction.size());
        Assertions.assertEquals(new Transaction(TODAY, ANY_AMOUNT), allTransaction.get(0));
    }
}
