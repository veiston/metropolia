import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task1 {
    public static void main(String[] args) throws Exception {
        /* Luetaan CSV verkosta ja keskiarvo */
        String url = "https://users.metropolia.fi/~jarkkov/temploki.csv";
        String pvm = "01.01.2023";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
        String body = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

        String[] lines = body.split("\\r?\\n");
        if (lines.length == 0) {
            System.out.println("Tyhjä tiedosto");
            return;
        }

        String[] headers = lines[0].split(";", -1);
        int timeIndex = indexOf(headers, "Aika");
        int ulkoTaloIndex = indexOf(headers, "UlkoTalo");

        if (timeIndex < 0 || ulkoTaloIndex < 0) {
            System.out.println("Ei löytynyt, ei löytynyt");
            return;
        }

        double sum = 0;
        int count = 0;

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(";", -1);
            if (parts.length <= Math.max(timeIndex, ulkoTaloIndex)) {
                continue;
            }

            String aika = parts[timeIndex].trim();
            if (!aika.startsWith(pvm)) {
                continue;
            }

            double temp = parseFinnishDouble(parts[ulkoTaloIndex]);
            if (Double.isNaN(temp)) {
                continue;
            }

            sum += temp;
            count++;
        }

        if (count == 0) {
            System.out.println("Ei mittauksia tälle päivälle " + pvm);
            return;
        }

        System.out.println("UlkoTalo keskiarvo " + pvm + ": " + (sum / count));
    }

    private static int indexOf(String[] headers, String name) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].trim().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    private static double parseFinnishDouble(String value) {
        String s = value.trim();
        if (s.isEmpty()) {
            return Double.NaN;
        }

        int i = 0;
        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
            i = 1;
        } else if (s.charAt(0) == '+') {
            i = 1;
        }

        long intPart = 0;
        long fracPart = 0;
        long fracDiv = 1;
        boolean hasDigits = false;
        boolean decimal = false;

        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                hasDigits = true;
                int digit = c - '0';
                if (!decimal) {
                    intPart = intPart * 10 + digit;
                } else {
                    fracPart = fracPart * 10 + digit;
                    fracDiv *= 10;
                }
            } 
            else if (c == ',' || c == '.') {
                if (decimal) {
                    return Double.NaN;
                }
                decimal = true;
            } else {
                return Double.NaN;
            }
        }

        if (!hasDigits) {
            return Double.NaN;
        }

        return sign * (intPart + (double) fracPart / fracDiv);
    }
}
