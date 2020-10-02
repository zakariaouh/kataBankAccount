package treatment;

public class Account {


    private TransactionRepository transactionRepository;
    private StatmentPrinter statmentPrinter;

    public Account(TransactionRepository transactionRepository, StatmentPrinter statmentPrinter) {

        this.transactionRepository = transactionRepository;
        this.statmentPrinter = statmentPrinter;
    }

    public void deposit(int amount) {
        transactionRepository.recode(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.recode(-amount);

    }

    public void printStatement() {
        statmentPrinter.print(transactionRepository.getAllTransaction());

    }
}
