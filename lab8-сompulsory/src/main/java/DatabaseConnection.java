import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USERNAME = "root"; // Имя пользователя root
    private static final String PASSWORD = ""; // Пустая строка для пароля
    private static Connection connection = null;

    private DatabaseConnection() {} // Private constructor to prevent instantiation

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
