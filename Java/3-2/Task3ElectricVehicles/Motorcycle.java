public class Motorcycle extends AbstractVehicle {
    private final String color;

    public Motorcycle() {
        super("Moottoripyörä", "Bensiini");
        this.color = "Musta";
    }

    protected String getDetails() {
        return "Väri: " + color;
    }
}
