import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureUnitTest {

    @Test
    void testConstructorAndGetters() {
        TemperatureUnit unit = new TemperatureUnit(1, "Celsius", "C");

        assertEquals(1, unit.getId());
        assertEquals("Celsius", unit.getName());
        assertEquals("C", unit.getSymbol());
        assertEquals("", unit.getDescription());
    }

    @Test
    void testConstructorWithDescription() {
        TemperatureUnit unit = new TemperatureUnit(1, "Celsius", "C", "Metric temperature scale");

        assertEquals(1, unit.getId());
        assertEquals("Celsius", unit.getName());
        assertEquals("C", unit.getSymbol());
        assertEquals("Metric temperature scale", unit.getDescription());
    }

    @Test
    void testToString() {
        TemperatureUnit unit = new TemperatureUnit("Fahrenheit", "F");

        assertEquals("Fahrenheit (F)", unit.toString());
    }
}
