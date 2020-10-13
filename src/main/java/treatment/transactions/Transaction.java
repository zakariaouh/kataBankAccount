package treatment.transactions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private final LocalDate date;
    private final BigDecimal amount;

    public Transaction(LocalDate date, BigDecimal amount) {
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

    public LocalDate date() {
        return date;
    }

    public BigDecimal amount() {
        return amount;
    }


}
