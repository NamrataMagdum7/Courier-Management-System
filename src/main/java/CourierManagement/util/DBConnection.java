package CourierManagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        System.out.println("Resource check: " + DBConnection.class.getClassLoader().getResource("db.properties"));
        if (connection == null) {
            try {
                Properties props = new Properties();
                InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");

                if (input == null) {
                    throw new RuntimeException("db.properties file not found in classpath");
                }

                props.load(input);

                String url = props.getProperty("db.url");
                String username = props.getProperty("db.username");
                String password = props.getProperty("db.password");
                String driver = props.getProperty("db.driver");

                Class.forName(driver); // Load driver
                connection = DriverManager.getConnection(url, username, password);

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to connect to database");
            }
        }
        return connection;
    }
}

