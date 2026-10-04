public class TempCalculator {

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    public double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public double convert(double value, String fromUnit, String toUnit) {
        if (fromUnit.equalsIgnoreCase(toUnit)) {
            return value;
        }

        // Convert to baseline (Celsius)
        double inCelsius = value;
        if (fromUnit.equalsIgnoreCase("Fahrenheit")) {
            inCelsius = fahrenheitToCelsius(value);
        } else if (fromUnit.equalsIgnoreCase("Kelvin")) {
            inCelsius = kelvinToCelsius(value);
        }

        // Convert baseline to destination
        if (toUnit.equalsIgnoreCase("Fahrenheit")) {
            return celsiusToFahrenheit(inCelsius);
        }
        if (toUnit.equalsIgnoreCase("Kelvin")) {
            return celsiusToKelvin(inCelsius);
        }

        return inCelsius;
    }
}
