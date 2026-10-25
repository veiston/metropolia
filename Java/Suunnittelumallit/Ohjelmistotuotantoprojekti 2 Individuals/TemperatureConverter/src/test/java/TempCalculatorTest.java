import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TempCalculatorTest {
    private static final double DELTA = 0.001;
    private TempCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TempCalculator();
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, calculator.celsiusToFahrenheit(0.0), DELTA);
        assertEquals(212.0, calculator.celsiusToFahrenheit(100.0), DELTA);
        assertEquals(-40.0, calculator.celsiusToFahrenheit(-40.0), DELTA);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, calculator.fahrenheitToCelsius(32.0), DELTA);
        assertEquals(100.0, calculator.fahrenheitToCelsius(212.0), DELTA);
        assertEquals(-40.0, calculator.fahrenheitToCelsius(-40.0), DELTA);
    }

    @Test
    void testKelvinToCelsius() {
        assertEquals(0.0, calculator.kelvinToCelsius(273.15), DELTA);
        assertEquals(100.0, calculator.kelvinToCelsius(373.15), DELTA);
        assertEquals(-273.15, calculator.kelvinToCelsius(0.0), DELTA);
    }

    @Test
    void testCelsiusToKelvin() {
        assertEquals(273.15, calculator.celsiusToKelvin(0.0), DELTA);
        assertEquals(373.15, calculator.celsiusToKelvin(100.0), DELTA);
    }

    @Test
    void testConvertSameUnit() {
        assertEquals(25.0, calculator.convert(25.0, "Celsius", "Celsius"), DELTA);
    }

    @Test
    void testConvertFahrenheitToKelvin() {
        // 32 F is 0 C, which is 273.15 K
        assertEquals(273.15, calculator.convert(32.0, "Fahrenheit", "Kelvin"), DELTA);
    }

    @Test
    void testConvertKelvinToFahrenheit() {
        // 373.15 K is 100 C, which is 212 F
        assertEquals(212.0, calculator.convert(373.15, "Kelvin", "Fahrenheit"), DELTA);
    }
}
