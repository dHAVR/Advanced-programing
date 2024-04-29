import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    private Connection connection;

    public AuthorDAO() throws SQLException {
        this.connection = DBConnectionManager.getConnection();
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


    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        String query = "SELECT id, name, origin_country, age FROM authors";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String origin_country = resultSet.getString("origin_country");
                int age = resultSet.getInt("age");

                Author author = new Author(id, name, origin_country, age);
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authors;
    }


    public void deleteBook(int bookId) {
        String query = "DELETE FROM authors WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
