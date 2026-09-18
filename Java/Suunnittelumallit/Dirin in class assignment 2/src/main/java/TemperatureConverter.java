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
}
