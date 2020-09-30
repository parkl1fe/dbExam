package service;

import model.Account;
import model.Account_transaction;
import model.Transaction;
import repository.AccountRepository;
import repository.Account_transactionRepository;
import repository.TransactionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransactionService {

    private static final String AUTOCOMMIT_OFF = "SET autocommit = OFF;";
    private static final String TRANSACTION_START = "START TRANSACTION;";
    private static final String TRANSACTION_COMMIT = "COMMIT;";
    private static final String AUTOCOMMIT_ON = "SET autocommit = ON;";
    private static final String TRANSACTION_ROLLBACK = "ROLLBACK;";

    Connection connection;
    PreparedStatement preparedStatement;

    public TransactionService(Connection connection) {
        this.connection = connection;
    }

    public void makeTransfer(Transaction transaction, Integer userId) throws SQLException {
        List<Account> useAccounts = new AccountRepository(connection).getBy(userId);
        Account account = useAccounts.stream()
                .filter(x -> x.getIban().equalsIgnoreCase(transaction.getDebtor_acc()))
                .findFirst()
                .get();

        try {
            if (account.getDisposable_balance() > transaction.getAmount()) {
                connection.prepareStatement(AUTOCOMMIT_OFF).executeQuery();
                connection.prepareStatement(TRANSACTION_START).executeQuery();

                new TransactionRepository(connection).create(transaction);
                new AccountRepository(connection).updateBalance(transaction.getCreditor_acc(), transaction.getAmount());

                new AccountRepository(connection).updateBalance(transaction.getDebtor_acc(), transaction.getAmount());
                new Account_transactionRepository(connection).create(new Account_transaction(transaction.getDebtor_acc(), transaction.getId()));
                new Account_transactionRepository(connection).create(new Account_transaction(transaction.getCreditor_acc(), transaction.getId()));

                connection.prepareStatement(TRANSACTION_COMMIT).executeQuery();
                connection.prepareStatement(AUTOCOMMIT_ON).executeQuery();
            }

        } catch (Exception e) {
            e.printStackTrace();
            connection.prepareStatement(TRANSACTION_ROLLBACK).executeQuery();
            connection.prepareStatement(AUTOCOMMIT_ON).executeQuery();

        }

    }


}
