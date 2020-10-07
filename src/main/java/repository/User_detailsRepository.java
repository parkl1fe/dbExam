package repository;

import model.User_details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_detailsRepository {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet rs;

    public User_detailsRepository(Connection connection) {
        this.connection = connection;
    }

    public User_details getBy(int id) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM user_details WHERE id = ?;");
        preparedStatement.setInt(1, id);
        rs = preparedStatement.executeQuery();
        User_details User_details = null;
        if (rs.next()) {
            User_details = new User_details(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDate(6));
        }
        preparedStatement.close();
        rs.close();
        return User_details;
    }

    public void create(User_details user_details) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO user_details VALUE (?,?,?,?,?,?);");
        preparedStatement.setInt(1, user_details.getId());
        preparedStatement.setString(2, user_details.getName());
        preparedStatement.setString(3, user_details.getSurname());
        preparedStatement.setString(4, user_details.getEmail());
        preparedStatement.setString(5, user_details.getTel_number());
        preparedStatement.setDate(6, user_details.getBirth_date());

        if (preparedStatement.executeUpdate() == 0) {
            throw new SQLException();
        }
    }

}
