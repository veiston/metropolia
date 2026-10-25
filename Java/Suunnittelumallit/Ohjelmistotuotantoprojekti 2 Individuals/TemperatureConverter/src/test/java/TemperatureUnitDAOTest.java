import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TemperatureUnitDAOTest {
    private static final String MEMORY_URL = "jdbc:sqlite::memory:";
    private Connection connection;
    private TemperatureUnitDAO dao;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DBConnection.getConnection(MEMORY_URL);
        dao = new TemperatureUnitDAO(connection);
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    void testFindDefaultUnits() throws SQLException {
        List<TemperatureUnit> units = dao.findAll();

        // Standard units inserted by DBConnection initDatabase
        assertTrue(units.size() >= 3);
    }

    @Test
    void testFindById() throws SQLException {
        TemperatureUnit unit = dao.findById(1);

        assertNotNull(unit);
        assertEquals("Celsius", unit.getName());
        assertEquals("C", unit.getSymbol());
    }

    @Test
    void testSave() throws SQLException {
        TemperatureUnit newUnit = new TemperatureUnit("Rankine", "R");
        dao.save(newUnit);

        List<TemperatureUnit> units = dao.findAll();
        boolean found = false;
        for (TemperatureUnit u : units) {
            if (u.getName().equals("Rankine")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }
}
