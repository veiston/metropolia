import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public TemperatureUnit findById(int id) throws SQLException {
        String sql = "SELECT id, name, symbol FROM temperature_unit WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new TemperatureUnit(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("symbol")
                    );
                }
            }
        }
        return null;
    }

    public List<TemperatureUnit> findAll() throws SQLException {
        List<TemperatureUnit> list = new ArrayList<>();
        String sql = "SELECT id, name, symbol FROM temperature_unit ORDER BY id;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                list.add(new TemperatureUnit(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("symbol")
                ));
            }
        }
        return list;
    }
}
