package Main;

import treatment.*;

public class BanKataApplication {

    public static void main(String args[]) {
        TransactionRepository transactionRepository = new TransactionRepository(new Clock());
        StatementPrinter statementPrinter = new StatementPrinter(new Console());
        Account account = new Account(transactionRepository, statementPrinter);
        account.deposit(500);
        account.deposit(2000);
        account.withdraw(700);
        account.printStatement();

    }
}
