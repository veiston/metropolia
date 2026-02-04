public class ElectricMotorcycle extends AbstractVehicle {
    private final String color;

    public ElectricMotorcycle() {
        super("Sähkömoottoripyörä", "Sähkö");
        this.color = "Valkoinen";
    }

    @Override
    public void charge() {
        System.out.println("Sähkömoottoripyörä lataa...");
    }

    protected String getDetails() {
        return "Väri: " + color;
    }
}
