import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDAO {
    private Connection connection;

    public AuthorDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void addAuthor(int id, String name, String origin_country, int age) {
        String query = "INSERT INTO authors (id, name, origin_country, age) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, origin_country);
            statement.setInt(4, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
