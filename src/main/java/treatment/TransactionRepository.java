package treatment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {
    List<Transaction> transactions;
    private final Clock clock;

    public TransactionRepository(Clock clock) {
        this.transactions = new ArrayList<>();
        this.clock = clock;
    }

    public void recode(BigDecimal amount) {
        transactions.add(new Transaction(clock.currentDayAsString(), amount));
    }

    public List<Transaction> getAllTransaction() {
        return Collections.unmodifiableList(transactions);
    }
}
