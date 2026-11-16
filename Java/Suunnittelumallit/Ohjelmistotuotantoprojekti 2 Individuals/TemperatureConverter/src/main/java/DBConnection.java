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
            // Temperature units base table
            statement.execute("CREATE TABLE IF NOT EXISTS temperature_unit ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "name TEXT NOT NULL UNIQUE, "
                    + "symbol TEXT NOT NULL);");

            // Unit translations table
            statement.execute("CREATE TABLE IF NOT EXISTS unit_translation ("
                    + "unit_id INTEGER NOT NULL, "
                    + "lang TEXT NOT NULL, "
                    + "name TEXT NOT NULL, "
                    + "description TEXT NOT NULL, "
                    + "PRIMARY KEY (unit_id, lang), "
                    + "FOREIGN KEY (unit_id) REFERENCES temperature_unit(id) ON DELETE CASCADE);");

            // Conversion records table
            statement.execute("CREATE TABLE IF NOT EXISTS temp_record ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "input_value REAL NOT NULL, "
                    + "source_unit_id INTEGER NOT NULL, "
                    + "output_value REAL NOT NULL, "
                    + "target_unit_id INTEGER NOT NULL, "
                    + "language TEXT NOT NULL DEFAULT 'en', "
                    + "timestamp TEXT NOT NULL DEFAULT '', "
                    + "FOREIGN KEY (source_unit_id) REFERENCES temperature_unit(id), "
                    + "FOREIGN KEY (target_unit_id) REFERENCES temperature_unit(id));");

            ensureColumns(statement);
            populateDefaultData(statement);
        }
    }

    private static void ensureColumns(Statement statement) {
        try {
            statement.execute("ALTER TABLE temp_record ADD COLUMN language TEXT NOT NULL DEFAULT 'en';");
        } catch (SQLException ignored) {
        }
        try {
            statement.execute("ALTER TABLE temp_record ADD COLUMN timestamp TEXT NOT NULL DEFAULT '';");
        } catch (SQLException ignored) {
        }
    }

    private static void populateDefaultData(Statement statement) throws SQLException {
        statement.execute("INSERT OR IGNORE INTO temperature_unit (id, name, symbol) VALUES (1, 'Celsius', 'C');");
        statement.execute("INSERT OR IGNORE INTO temperature_unit (id, name, symbol) VALUES (2, 'Fahrenheit', 'F');");
        statement.execute("INSERT OR IGNORE INTO temperature_unit (id, name, symbol) VALUES (3, 'Kelvin', 'K');");

        String[][] translations = {
            {"1", "en", "Celsius", "Metric temperature scale based on 0°C freezing and 100°C boiling point."},
            {"1", "fi", "Celsius", "Metrinen lämpötila-asteikko, jossa veden jäätymispiste on 0 °C ja kiehumispiste 100 °C."},
            {"1", "sv", "Celsius", "Metrisk temperaturskala där vattnets fryspunkt är 0 °C och kokpunkt 100 °C."},
            {"1", "ja", "摂氏", "水の氷点を0度、沸点を100度とする温度目盛。"},
            {"1", "ar", "درجة مئوية", "مقياس درجة حرارة يعتمد على تجمد الماء عند 0 درجة وغليانه عند 100 درجة."},

            {"2", "en", "Fahrenheit", "Scale where water freezes at 32°F and boils at 212°F."},
            {"2", "fi", "Fahrenheit", "Lämpötila-asteikko, jossa vesi jäätyy 32 °F ja kiehuu 212 °F lämpötilassa."},
            {"2", "sv", "Fahrenheit", "Temperaturskala där vatten fryser vid 32 °F och kokar vid 212 °F."},
            {"2", "ja", "華氏", "水の氷点を32度、沸点を212度とする温度目盛。"},
            {"2", "ar", "فهرنهايت", "مقياس درجة حرارة يتجمد عنده الماء عند 32 درجة ويغلي عند 212 درجة."},

            {"3", "en", "Kelvin", "Absolute temperature scale starting at absolute zero (0 K)."},
            {"3", "fi", "Kelvin", "Absoluuttinen lämpötila-asteikko, jonka nollapiste on absoluuttinen nollapiste."},
            {"3", "sv", "Kelvin", "Absolut temperaturskala som börjar vid absoluta nollpunkten."},
            {"3", "ja", "ケルビン", "絶対零度を0とする絶対温度目盛。"},
            {"3", "ar", "كلفن", "مقياس درجة الحرارة المطلقة بدءا من الصفر المطلق."}
        };

        for (String[] row : translations) {
            String sql = "INSERT OR IGNORE INTO unit_translation (unit_id, lang, name, description) VALUES ("
                    + row[0] + ", '" + row[1] + "', '" + row[2] + "', '" + row[3] + "');";
            statement.execute(sql);
        }
    }
}
