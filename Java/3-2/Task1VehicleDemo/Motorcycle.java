public class Motorcycle implements Vehicle {
    private final String fuel;
    private final String color;

    public Motorcycle() {
        this.fuel = "Bensiini";
        this.color = "Musta";
    }

    public void start() {
        System.out.println("Moottoripyörä käynnistyy...");
    }

    public void stop() {
        System.out.println("Moottoripyörä pysähtyy...");
    }

    public String getInfo() {
        return "Moottoripyörä\n" +
                "Polttoaine: " + fuel + "\n" +
                "Väri: " + color;
    }
}
