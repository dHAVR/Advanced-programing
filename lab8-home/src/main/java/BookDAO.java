import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO() throws SQLException {
        this.connection = DBConnectionManager.getConnection();
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT id, title, language, publication_date, number_of_pages, authors FROM books";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String language = resultSet.getString("language");
                String publicationDate = resultSet.getString("publication_date");
                int numberOfPages = resultSet.getInt("number_of_pages");
                String authors = resultSet.getString("authors");

                Book book = new Book(id, title, language, publicationDate, numberOfPages, authors);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public void addBook(Book book) {
        String query = "INSERT INTO books (title, language, publication_date, number_of_pages, authors) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getLanguage());
            statement.setString(3, book.getPublicationDate());
            statement.setInt(4, book.getNumberOfPages());
            statement.setString(5, book.getAuthors());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId) {
        String query = "DELETE FROM books WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
