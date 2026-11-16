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
        assertEquals("en", saved.getLanguage());
    }

    @Test
    void testSaveAndFindRecentLimitFive() throws SQLException {
        // Save 7 conversion records
        for (int i = 1; i <= 7; i++) {
            TempRecord record = new TempRecord(
                    i * 10.0,
                    1,
                    i * 18.0 + 32.0,
                    2,
                    "ja",
                    "2026-11-06 00:00:0" + i
            );
            dao.save(record);
        }

        List<TempRecord> recent = dao.findRecent(5);
        assertEquals(5, recent.size());

        // Most recent record (7th inserted) should be first
        TempRecord mostRecent = recent.get(0);
        assertEquals(70.0, mostRecent.getInputValue(), DELTA);
        assertEquals("ja", mostRecent.getLanguage());
        assertEquals("2026-11-06 00:00:07", mostRecent.getTimestamp());

        // Fifth most recent record should be the 3rd inserted (value 30.0)
        TempRecord fifthRecent = recent.get(4);
        assertEquals(30.0, fifthRecent.getInputValue(), DELTA);
    }
}
