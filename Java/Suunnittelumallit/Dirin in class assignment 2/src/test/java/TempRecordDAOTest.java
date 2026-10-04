import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TempRecordDAOTest {
    private static final String MEMORY_URL = "jdbc:sqlite::memory:";
    private static final double DELTA = 0.001;
    private Connection connection;
    private TempRecordDAO dao;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DBConnection.getConnection(MEMORY_URL);
        dao = new TempRecordDAO(connection);
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    void testSaveAndFindAll() throws SQLException {
        TempRecord record = new TempRecord(100.0, 1, 212.0, 2);
        dao.save(record);

        List<TempRecord> list = dao.findAll();
        assertTrue(list.size() >= 1);

        TempRecord saved = list.get(0);
        assertEquals(100.0, saved.getInputValue(), DELTA);
        assertEquals(1, saved.getSourceUnitId());
        assertEquals(212.0, saved.getOutputValue(), DELTA);
        assertEquals(2, saved.getTargetUnitId());
    }
}
