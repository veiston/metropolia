import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

        assertTrue(units.size() >= 3);
        assertEquals("Celsius", units.get(0).getName());
        assertEquals("C", units.get(0).getSymbol());
        assertFalse(units.get(0).getDescription().isEmpty());
    }

    @Test
    void testFindById() throws SQLException {
        TemperatureUnit unit = dao.findById(1);

        assertNotNull(unit);
        assertEquals("Celsius", unit.getName());
        assertEquals("C", unit.getSymbol());
        assertFalse(unit.getDescription().isEmpty());
    }

    @Test
    void testFindAllLocalizedJapanese() throws SQLException {
        List<TemperatureUnit> units = dao.findAll("ja");

        assertTrue(units.size() >= 3);
        assertEquals("摂氏", units.get(0).getName());
        assertEquals("華氏", units.get(1).getName());
        assertEquals("ケルビン", units.get(2).getName());
        assertFalse(units.get(0).getDescription().isEmpty());
    }

    @Test
    void testFindAllLocalizedArabic() throws SQLException {
        List<TemperatureUnit> units = dao.findAll("ar");

        assertTrue(units.size() >= 3);
        assertEquals("درجة مئوية", units.get(0).getName());
        assertEquals("فهرنهايت", units.get(1).getName());
        assertEquals("كلفن", units.get(2).getName());
        assertFalse(units.get(0).getDescription().isEmpty());
    }

    @Test
    void testFindAllLocalizedFinnish() throws SQLException {
        List<TemperatureUnit> units = dao.findAll("fi");

        assertTrue(units.size() >= 3);
        assertEquals("Celsius", units.get(0).getName());
        assertTrue(units.get(0).getDescription().contains("Metrinen"));
    }

    @Test
    void testFindAllLocalizedSwedish() throws SQLException {
        List<TemperatureUnit> units = dao.findAll("sv");

        assertTrue(units.size() >= 3);
        assertEquals("Celsius", units.get(0).getName());
        assertTrue(units.get(0).getDescription().contains("Metrisk"));
    }

    @Test
    void testFallbackToEnglishWhenLanguageNotFound() throws SQLException {
        // Request language with no translations (German "de")
        List<TemperatureUnit> units = dao.findAll("de");

        assertTrue(units.size() >= 3);
        // Falls back to English
        assertEquals("Celsius", units.get(0).getName());
        assertEquals("Fahrenheit", units.get(1).getName());
        assertEquals("Kelvin", units.get(2).getName());
        assertTrue(units.get(0).getDescription().contains("Metric temperature scale"));
    }

    @Test
    void testFindByIdLocalizedAndFallback() throws SQLException {
        TemperatureUnit japaneseUnit = dao.findById(1, "ja");
        assertNotNull(japaneseUnit);
        assertEquals("摂氏", japaneseUnit.getName());

        // Unknown language falls back to English
        TemperatureUnit fallbackUnit = dao.findById(1, "unknown_lang");
        assertNotNull(fallbackUnit);
        assertEquals("Celsius", fallbackUnit.getName());
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

    @Test
    void testSaveTranslation() throws SQLException {
        dao.saveTranslation(1, "de", "Grad Celsius", "Metrische Temperaturskala");

        TemperatureUnit unit = dao.findById(1, "de");
        assertNotNull(unit);
        assertEquals("Grad Celsius", unit.getName());
        assertEquals("Metrische Temperaturskala", unit.getDescription());
    }
}
