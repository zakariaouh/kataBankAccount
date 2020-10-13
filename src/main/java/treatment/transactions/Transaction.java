package treatment.transactions;

import java.math.BigDecimal;
import java.util.Objects;

public class Transaction {
    private final String date;
    private final BigDecimal amount;

    public Transaction(String date, BigDecimal amount) {

        this.date = date;
        this.amount = amount;
    }

    public boolean isDebit() {
        return amount.signum() != -1;
    }

    public boolean isCredit() {
        return amount.signum() == -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }

    public String date() {
        return date;
    }

    public BigDecimal amount() {
        return amount;
    }


}
