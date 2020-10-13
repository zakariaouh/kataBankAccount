package treatment;

import java.math.BigDecimal;

public class Account {


    private final TransactionRepository transactionRepository;
    private final StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {

        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(BigDecimal amount) {
        transactionRepository.record(amount);
    }

    public void withdraw(BigDecimal amount) {
        transactionRepository.record(amount.negate());

    }

    public void printStatement() {
        statementPrinter.print(transactionRepository.getAllTransaction());

    }
}
