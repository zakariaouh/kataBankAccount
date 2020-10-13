package treatment.transactions;

import treatment.tools.Clock;

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

    public void record(BigDecimal amount) {
        transactions.add(new Transaction(clock.today(), amount));
    }

    public List<Transaction> getAllTransaction() {
        return Collections.unmodifiableList(transactions);
    }
}
