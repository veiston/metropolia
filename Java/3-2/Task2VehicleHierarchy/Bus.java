public class Bus extends AbstractVehicle {
    private final int capacity;

    public Bus() {
        super("Bussi", "Diesel");
        this.capacity = 40;
    }

    protected String getDetails() {
        return "Kapasiteetti: " + capacity;
    }
}
