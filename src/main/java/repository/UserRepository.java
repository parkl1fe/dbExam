package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRepository {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet rs;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public User getBy(int id) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE id = ?;");
        preparedStatement.setInt(1, id);
        rs = preparedStatement.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User(rs.getInt(1), rs.getString(2));
        }
        preparedStatement.close();
        rs.close();
        return user;
    }

    public void create(User user) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO user (id, password) VALUE (?,?);");
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getPassword());
        if (preparedStatement.executeUpdate() == 0) {
            throw new SQLException();
        }
    }

}
