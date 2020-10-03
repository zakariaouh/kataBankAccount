package treatment;

import mockito.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountTest {
    private Account account;
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    StatementPrinter statementPrinter;
    private final BigDecimal ANY_AMOUNT = new BigDecimal(500);

    @BeforeEach
    void setUp() {
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    void accountDepositShouldRecordATransactionWithTheSameAmount() {
        account.deposit(ANY_AMOUNT);
        verify(transactionRepository).recode(ANY_AMOUNT);

    }

    @Test
    void accountWithdrawShouldRecordATransactionWithTheMinusAmount() {
        account.withdraw(ANY_AMOUNT);
        verify(transactionRepository).recode(ANY_AMOUNT.negate());

    }

    @Test
    void accountPrintStatementShouldCallThePrinterWithAllAccountTransactions() {
        List<Transaction> transactions = Collections.singletonList(new Transaction(null, new BigDecimal(100)));
        given(transactionRepository.getAllTransaction()).willReturn(transactions);
        account.printStatement();
        verify(statementPrinter).print(transactions);

    }
}
