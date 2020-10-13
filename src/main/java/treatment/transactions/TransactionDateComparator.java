package treatment.transactions;

import java.util.Comparator;

public class TransactionDateComparator implements Comparator<Transaction> {
    @Override
    public int compare(Transaction o1, Transaction o2) {
        return o1.date().compareTo(o2.date());

    }
}
