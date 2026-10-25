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
        assertEquals(37.0, converter.fahrenheitToCelsius(98.6), 0.001);
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.001);
        assertEquals(212.0, converter.celsiusToFahrenheit(100.0), 0.001);
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40.0), 0.001);
        assertEquals(98.6, converter.celsiusToFahrenheit(37.0), 0.001);
    }

    @Test
    void testKelvinToCelsius() {
        assertEquals(0.0, converter.kelvinToCelsius(273.15), 0.001);
        assertEquals(100.0, converter.kelvinToCelsius(373.15), 0.001);
        assertEquals(-273.15, converter.kelvinToCelsius(0.0), 0.001);
    }

    @Test
    void testIsExtremeTemperature() {
        // Required edge and boundary cases: -40, 50, -41, 51
        assertTrue(converter.isExtremeTemperature(-41.0));
        assertFalse(converter.isExtremeTemperature(-40.0));
        assertFalse(converter.isExtremeTemperature(0.0));
        assertFalse(converter.isExtremeTemperature(50.0));
        assertTrue(converter.isExtremeTemperature(51.0));

        // Precision boundary checks
        assertTrue(converter.isExtremeTemperature(-40.1));
        assertTrue(converter.isExtremeTemperature(50.1));
    }

    @Test
    void testMain() {
        TemperatureConverter.main(new String[]{});
    }
}
