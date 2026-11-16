import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TemperatureUnitDAO {
    private final Connection connection;

    public TemperatureUnitDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(TemperatureUnit unit) throws SQLException {
        String sql = "INSERT INTO temperature_unit (name, symbol) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, unit.getName());
            statement.setString(2, unit.getSymbol());
            statement.executeUpdate();
        }
    }

    public void saveTranslation(int unitId, String lang, String name, String description) throws SQLException {
        String sql = "INSERT OR REPLACE INTO unit_translation (unit_id, lang, name, description) VALUES (?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, unitId);
            statement.setString(2, lang);
            statement.setString(3, name);
            statement.setString(4, description);
            statement.executeUpdate();
        }
    }

    public TemperatureUnit findById(int id, String lang) throws SQLException {
        String sql = "SELECT u.id, u.symbol, "
                + "COALESCE(t.name, fallback.name, u.name) AS localized_name, "
                + "COALESCE(t.description, fallback.description, '') AS localized_desc "
                + "FROM temperature_unit u "
                + "LEFT JOIN unit_translation t ON u.id = t.unit_id AND t.lang = ? "
                + "LEFT JOIN unit_translation fallback ON u.id = fallback.unit_id AND fallback.lang = 'en' "
                + "WHERE u.id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lang);
            statement.setInt(2, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new TemperatureUnit(
                            resultSet.getInt("id"),
                            resultSet.getString("localized_name"),
                            resultSet.getString("symbol"),
                            resultSet.getString("localized_desc")
                    );
                }
            }
        }
        return null;
    }

    public TemperatureUnit findById(int id) throws SQLException {
        return findById(id, "en");
    }

    public List<TemperatureUnit> findAll(String lang) throws SQLException {
        List<TemperatureUnit> list = new ArrayList<>();
        String sql = "SELECT u.id, u.symbol, "
                + "COALESCE(t.name, fallback.name, u.name) AS localized_name, "
                + "COALESCE(t.description, fallback.description, '') AS localized_desc "
                + "FROM temperature_unit u "
                + "LEFT JOIN unit_translation t ON u.id = t.unit_id AND t.lang = ? "
                + "LEFT JOIN unit_translation fallback ON u.id = fallback.unit_id AND fallback.lang = 'en' "
                + "ORDER BY u.id;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lang);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(new TemperatureUnit(
                            resultSet.getInt("id"),
                            resultSet.getString("localized_name"),
                            resultSet.getString("symbol"),
                            resultSet.getString("localized_desc")
                    ));
                }
            }
        }
        return list;
    }

    public List<TemperatureUnit> findAll() throws SQLException {
        return findAll("en");
    }
}
