package repository;

import model.Account;
import model.enums.Account_type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet rs;

    public AccountRepository(Connection connection) {
        this.connection = connection;
    }

    public Account getBy(String iban) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE iban = ?;");
        preparedStatement.setString(1, iban);
        rs = preparedStatement.executeQuery();
        Account account = null;
        if (rs.next()) {
            account = new Account(rs.getString(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    Account_type.fromString(rs.getString(5)),
                    rs.getInt(6),
                    rs.getString(6));
        }
        return account;
    }

    public List<Account> getBy(int owner) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE user_id = ?;");
        preparedStatement.setInt(1, owner);
        rs = preparedStatement.executeQuery();
        Account account = null;
        List<Account> accountList = new ArrayList<>();
        while (rs.next()) {
            account = new Account(rs.getString(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    Account_type.fromString(rs.getString(5)),
                    rs.getInt(6),
                    rs.getString(7));
            accountList.add(account);
        }
        return accountList;
    }

    public void create(Account account) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO account VALUE (?,?,?,?,?,?,?);");
        preparedStatement.setString(1, account.getIban());
        preparedStatement.setInt(2, account.getUser_id());
        preparedStatement.setDouble(3, account.getDisposable_balance());
        preparedStatement.setInt(4, account.getCredit());
        preparedStatement.setString(5, account.getAccount_type().toString());
        preparedStatement.setInt(6, account.getInterest_rate());
        preparedStatement.setString(7, account.getCurrency());
        if (preparedStatement.executeUpdate() == 0) {
            throw new SQLException();
        }
    }

    public void updateBalance(String iban, double balanceChange) throws SQLException {
        Double newBalance = getBy(iban).getDisposable_balance() + balanceChange;
        preparedStatement = connection.prepareStatement("UPDATE account SET disposable_balance = ? WHERE iban = ?;");
        preparedStatement.setDouble(1, newBalance);
        preparedStatement.setString(2, iban);
        if (preparedStatement.executeUpdate() == 0) {
            throw new SQLException();
        }
    }

}
