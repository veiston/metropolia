public class TemperatureConverter {

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double kelvinToCelsius(double kelvin) {
        return (kelvin - 273.15);
    }

    public boolean isExtremeTemperature(double celsius) {
        if (50.0 < celsius || celsius < -40.0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();
        System.out.println("=== Temperature Converter ===");
        System.out.println("100.0 C = " + converter.celsiusToFahrenheit(100.0) + " F");
        System.out.println("32.0 F = " + converter.fahrenheitToCelsius(32.0) + " C");
        System.out.println("300.0 K = " + converter.kelvinToCelsius(300.0) + " C");
    }
}
