import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Read data from CSV and import into database
        importDataFromCSV("books.csv");
    }

    private static void importDataFromCSV(String csvFilePath) {
        try (Connection connection = DBConnectionManager.getConnection();
             FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fileReader)) {

            String insertQuery = "INSERT INTO books (title, authors, average_rating, isbn, isbn13, language_code, num_pages, ratings_count, text_reviews_count, publication_date, publisher) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                for (CSVRecord record : csvParser) {
                    statement.setString(1, record.get("title"));
                    statement.setString(2, record.get("authors"));
                    statement.setDouble(3, Double.parseDouble(record.get("average_rating")));
                    statement.setString(4, record.get("isbn"));
                    statement.setString(5, record.get("isbn13"));
                    statement.setString(6, record.get("language_code"));
                    statement.setInt(7, Integer.parseInt(record.get("num_pages")));
                    statement.setInt(8, Integer.parseInt(record.get("ratings_count")));
                    statement.setInt(9, Integer.parseInt(record.get("text_reviews_count")));
                    SimpleDateFormat inputFormat = new SimpleDateFormat("M/d/yyyy");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = inputFormat.parse(record.get("publication_date"));
                    String formattedDate = outputFormat.format(date);
                    statement.setDate(10, java.sql.Date.valueOf(formattedDate));
                    statement.setString(11, record.get("publisher"));

                    // Execute the statement
                    statement.executeUpdate();
                }
                System.out.println("Data imported successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
