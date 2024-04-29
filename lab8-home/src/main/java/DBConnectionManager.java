import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class DBConnectionManager {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/library";
    private static final String USERNAME = "root";

    private static DataSource dataSource;

    static {
        initializeDataSource();
    }

    private static void initializeDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(JDBC_URL);
        basicDataSource.setUsername(USERNAME);

        basicDataSource.setInitialSize(5); // Initial number of connections
        basicDataSource.setMaxTotal(10);  // Maximum number of connections
        basicDataSource.setMaxIdle(5);    // Maximum number of idle connections
        basicDataSource.setMinIdle(2);    // Minimum number of idle connections
        basicDataSource.setMaxWaitMillis(5000); // Maximum wait time for a connection

        dataSource = basicDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void releaseConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
