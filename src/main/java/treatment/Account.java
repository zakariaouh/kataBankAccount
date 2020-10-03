package treatment;

public class Account {


    private final TransactionRepository transactionRepository;
    private final StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {

        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionRepository.recode(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.recode(-amount);

    }

    public void printStatement() {
        statementPrinter.print(transactionRepository.getAllTransaction());

    }
}
