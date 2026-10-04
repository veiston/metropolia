import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TempRecordDAO {
    private final Connection connection;

    public TempRecordDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(TempRecord record) throws SQLException {
        String sql = "INSERT INTO temp_record (input_value, source_unit_id, output_value, target_unit_id) VALUES (?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, record.getInputValue());
            statement.setInt(2, record.getSourceUnitId());
            statement.setDouble(3, record.getOutputValue());
            statement.setInt(4, record.getTargetUnitId());
            statement.executeUpdate();
        }
    }

    public List<TempRecord> findAll() throws SQLException {
        List<TempRecord> list = new ArrayList<>();
        String sql = "SELECT id, input_value, source_unit_id, output_value, target_unit_id FROM temp_record ORDER BY id DESC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                list.add(new TempRecord(
                        resultSet.getInt("id"),
                        resultSet.getDouble("input_value"),
                        resultSet.getInt("source_unit_id"),
                        resultSet.getDouble("output_value"),
                        resultSet.getInt("target_unit_id")
                ));
            }
        }
        return list;
    }
}
