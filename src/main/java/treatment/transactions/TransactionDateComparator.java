package treatment.transactions;

import treatment.Clock;

import java.time.LocalDate;
import java.util.Comparator;

public class TransactionDateComparator implements Comparator<Transaction> {
    @Override
    public int compare(Transaction o1, Transaction o2) {
        Clock c=new Clock();
        LocalDate d1=c.stringToDate(o1.date());
        LocalDate d2=c.stringToDate(o2.date());
        return d1.compareTo(d2);

    }
}
