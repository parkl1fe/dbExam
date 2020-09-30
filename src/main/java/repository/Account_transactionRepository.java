package repository;

import model.Account_transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Account_transactionRepository {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet rs;

    public Account_transactionRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Account_transaction> getBy(String iban) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM account_transaction WHERE account_id = ?;");
        preparedStatement.setString(1, iban);
        rs = preparedStatement.executeQuery();
        List<Account_transaction> account_transactions = new ArrayList<>();
        while (rs.next()) {
            account_transactions.add(new Account_transaction(rs.getString(2), rs.getInt(3)));
        }
        return account_transactions;
    }

    public void create(Account_transaction account_transaction) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO account_transaction (account_id, transaction_id) VALUE (?, ?)");
        preparedStatement.setString(1, account_transaction.getAccount_id());
        preparedStatement.setInt(2, account_transaction.getTransaction_id());
        if (preparedStatement.executeUpdate() == 0) {
            throw new SQLException();
        }
    }




}
