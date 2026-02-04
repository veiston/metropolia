public class ElectricCar extends AbstractVehicle {
    private final String color;

    public ElectricCar() {
        super("Sähköauto", "Sähkö");
        this.color = "Sininen";
    }

    @Override
    public void charge() {
        System.out.println("Sähköauto lataa...");
    }

    protected String getDetails() {
        return "Väri: " + color;
    }
}
