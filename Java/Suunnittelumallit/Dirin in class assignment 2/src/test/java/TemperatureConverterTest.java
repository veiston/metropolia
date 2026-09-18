import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemperatureConverterTest {

    private TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32.0), 0.001);
        assertEquals(100.0, converter.fahrenheitToCelsius(212.0), 0.001);
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40.0), 0.001);
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.001);
        assertEquals(212.0, converter.celsiusToFahrenheit(100.0), 0.001);
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40.0), 0.001);
    }

    @Test
    void testkelvinToCelsius() {
        assertEquals(0, converter.kelvinToCelsius(273.15), 0.001);
        assertEquals(100, converter.kelvinToCelsius(373.15), 0.001);
        assertEquals(-273.15, converter.kelvinToCelsius(0), 0.001);
    }

    @Test
    void testIsExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(-40.1));
        assertFalse(converter.isExtremeTemperature(-40.0));
        assertFalse(converter.isExtremeTemperature(0.0));
        assertFalse(converter.isExtremeTemperature(50.0));
        assertTrue(converter.isExtremeTemperature(69.1));
    }
}
