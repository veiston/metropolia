public class Car implements Vehicle {
    private final String fuel;
    private final String color;

    public Car() {
        this.fuel = "Bensiini";
        this.color = "Punainen";
    }

    public void start() {
        System.out.println("Auto käynnistyy...");
    }

    public void stop() {
        System.out.println("Auto pysähtyy...");
    }

    public String getInfo() {
        return "Auto\n" +
                "Polttoaine: " + fuel + "\n" +
                "Väri: " + color;
    }
}
