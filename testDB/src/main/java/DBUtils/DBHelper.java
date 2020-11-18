package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
    private static final String username = "quizz_app";
    private static final String password = "app";
    private static final String url = "jdbc:mysql://localhost:3306/POO_TP2_QUIZZ";
    private static Connection connection;

    public DBHelper() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public Statement getDatabase() throws SQLException {
        return connection.createStatement();
    }
}
