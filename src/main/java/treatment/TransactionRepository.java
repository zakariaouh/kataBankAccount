package treatment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {
    List<Transaction> transactions;
    private Clock clock;

    public TransactionRepository(Clock clock) {
        this.transactions = new ArrayList<>();
        this.clock = clock;
    }

    public void recode(int amount) {
        transactions.add(new Transaction(clock.currentDayAsString(), amount));
    }

    public List<Transaction> getAllTransaction() {
        return Collections.unmodifiableList(transactions);
    }
}
