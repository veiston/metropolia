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
        if (isFahrenheit(fromUnit)) {
            inCelsius = fahrenheitToCelsius(value);
        } else if (isKelvin(fromUnit)) {
            inCelsius = kelvinToCelsius(value);
        }

        // Convert baseline to destination
        if (isFahrenheit(toUnit)) {
            return celsiusToFahrenheit(inCelsius);
        }
        if (isKelvin(toUnit)) {
            return celsiusToKelvin(inCelsius);
        }

        return inCelsius;
    }

    private boolean isFahrenheit(String unit) {
        if (unit.equalsIgnoreCase("Fahrenheit") || unit.equalsIgnoreCase("F")) {
            return true;
        }
        return false;
    }

    private boolean isKelvin(String unit) {
        if (unit.equalsIgnoreCase("Kelvin") || unit.equalsIgnoreCase("K")) {
            return true;
        }
        return false;
    }
}
