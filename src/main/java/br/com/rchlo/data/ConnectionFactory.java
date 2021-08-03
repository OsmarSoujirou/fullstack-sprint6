package br.com.rchlo.data;

import java.sql.*;

public class ConnectionFactory {

    private ConnectionFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://root:123456@localhost:3306/rchlo");
        } catch (SQLException ex) {
            throw new IllegalStateException("Error while connecting with database", ex);
        }
    }


    public static ResultSet sqlService(String query) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            return preparedStatement.executeQuery();

        } catch (SQLException ex) {
            throw new IllegalStateException("Error retrieving payments", ex);
        }
    }
}
