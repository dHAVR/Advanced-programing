import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            System.out.println("Connection established successfully!");
            // Теперь вы можете использовать 'connection' для выполнения запросов к базе данных
            try {
                connection.close(); // После использования соединения, не забудьте закрыть его
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to establish connection.");
        }
    }
}
