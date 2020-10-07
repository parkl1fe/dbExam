package repository;

import model.Transaction;
import model.enums.Transaction_type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet rs;

    public TransactionRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Transaction> getBy(Integer id) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM transaction WHERE id = ?;");
        preparedStatement.setInt(1, id);
        rs = preparedStatement.executeQuery();
        List<Transaction> transactions = new ArrayList<>();
        while (rs.next()) {
            transactions.add(new Transaction(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4),
                    rs.getDate(5),
                    Transaction_type.fromString(rs.getString(6)),
                    rs.getString(7)
                    ));
        }
        return transactions;
    }

    public void create(Transaction transaction) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO transaction (id, debtor_acc, creditor_acc, amount, execution_date, transaction_type, currency) VALUE (?,?,?,?,?,?,?);");
        preparedStatement.setInt(1, transaction.getId());
        preparedStatement.setString(2, transaction.getDebtor_acc());
        preparedStatement.setString(3, transaction.getCreditor_acc());
        preparedStatement.setDouble(4, transaction.getAmount());
        preparedStatement.setDate(5, transaction.getExecution_date());
        preparedStatement.setString(6, transaction.getTransaction_type().toString());
        preparedStatement.setString(7, transaction.getCurrency());

        if (preparedStatement.executeUpdate() == 0) {
            throw new SQLException();
        }
    }

}
