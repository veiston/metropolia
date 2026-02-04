public class Bus implements Vehicle {
    private final String fuel;
    private final int capacity;

    public Bus() {
        this.fuel = "Diesel";
        this.capacity = 40;
    }

    public void start() {
        System.out.println("Bussi käynnistyy...");
    }

    public void stop() {
        System.out.println("Bussin matka loppu tähän...");
    }

    public String getInfo() {
        return "Bussi\n" +
            "Polttoaine: " + fuel + "\n" +
            "Kapasiteetti: " + capacity + " matkustajaa";
    }
}
