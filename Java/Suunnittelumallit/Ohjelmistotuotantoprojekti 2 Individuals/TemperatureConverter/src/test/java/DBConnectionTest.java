import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DBConnectionTest {
    private static final String MEMORY_URL = "jdbc:sqlite::memory:";

    @Test
    void testGetConnectionAndInit() throws SQLException {
        try (Connection connection = DBConnection.getConnection(MEMORY_URL)) {
            assertNotNull(connection);
            assertFalse(connection.isClosed());
        }
    }
}
