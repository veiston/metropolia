import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String DEFAULT_URL = "jdbc:sqlite:temperature.db";

    public static Connection getConnection() throws SQLException {
        return getConnection(DEFAULT_URL);
    }

    public static Connection getConnection(String url) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        initDatabase(connection);
        return connection;
    }

    public static void initDatabase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            // Create table for temperature units
            statement.execute("CREATE TABLE IF NOT EXISTS temperature_unit ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "name TEXT NOT NULL UNIQUE, "
                    + "symbol TEXT NOT NULL);");

            // Create table for conversion records
            statement.execute("CREATE TABLE IF NOT EXISTS temp_record ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "input_value REAL NOT NULL, "
                    + "source_unit_id INTEGER NOT NULL, "
                    + "output_value REAL NOT NULL, "
                    + "target_unit_id INTEGER NOT NULL, "
                    + "FOREIGN KEY (source_unit_id) REFERENCES temperature_unit(id), "
                    + "FOREIGN KEY (target_unit_id) REFERENCES temperature_unit(id));");

            // Populate standard units if empty
            statement.execute("INSERT OR IGNORE INTO temperature_unit (id, name, symbol) VALUES (1, 'Celsius', 'C');");
            statement.execute("INSERT OR IGNORE INTO temperature_unit (id, name, symbol) VALUES (2, 'Fahrenheit', 'F');");
            statement.execute("INSERT OR IGNORE INTO temperature_unit (id, name, symbol) VALUES (3, 'Kelvin', 'K');");
        }
    }
}
