package main;

import treatment.*;
import treatment.statment.Console;
import treatment.statment.StatementPrinter;
import treatment.tools.Clock;
import treatment.transactions.TransactionRepository;

import java.math.BigDecimal;

public class BanKataApplication {

    public static void main(String [] args) {
        TransactionRepository transactionRepository = new TransactionRepository(new Clock());
        StatementPrinter statementPrinter = new StatementPrinter(new Console());
        Account account = new Account(transactionRepository, statementPrinter);
        account.deposit(new BigDecimal(500));
        account.deposit(new BigDecimal(2000));
        account.withdraw(new BigDecimal(700));
        account.printStatement();

    }
}
