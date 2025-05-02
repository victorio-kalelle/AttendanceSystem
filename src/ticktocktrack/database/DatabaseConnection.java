package ticktocktrack.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection conn;

    // Loads configuration from the properties file
    private void loadConfig() throws SQLException, IOException {
        // Print current working directory to help debug the path issue
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        Properties properties = new Properties();

        // Load from the relative path: resources/config.properties
        try (FileInputStream fis = new FileInputStream("resources/config.properties")) {
            properties.load(fis);
        }

        String dbUrl = properties.getProperty("db.url");
        String dbUsername = properties.getProperty("db.username");
        String dbPassword = properties.getProperty("db.password");

        if (dbUrl == null || dbUsername == null || dbPassword == null) {
            throw new SQLException("Database connection details are missing in config.properties.");
        }

        conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    // Connect to SQL Server using loaded configuration
    public void connectToSQLServer() throws SQLException, IOException {
        if (conn == null || conn.isClosed()) {
            loadConfig();
        }
    }

    // Test connection and print result
    public void testConnection() {
        try {
            connectToSQLServer();
            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ Database connection successful!");
            } else {
                System.out.println("❌ Database connection failed.");
            }
        } catch (SQLException | IOException e) {
            System.out.println("⚠️ Error connecting to the database: " + e.getMessage());
        }
    }

    // Method to retrieve stored password hash from the database
    public String getStoredPasswordHash(String query, String username) throws SQLException {
        // TODO: Implement with PreparedStatement using query and username
        return null;
    }

    // Close connection when done
    public void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
