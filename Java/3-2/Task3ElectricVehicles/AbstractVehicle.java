public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    private final String type;
    private final String fuel;

    protected AbstractVehicle(String type, String fuel) {
        this.type = type;
        this.fuel = fuel;
    }

    protected String getType() {
        return type;
    }

    protected String getFuel() {
        return fuel;
    }

    public void start() {
        System.out.println(type + " käynnistyy...");
    }

    public void stop() {
        System.out.println(type + " pysähtyy...");
    }

    public void charge() {
        System.out.println("Ei voi ladata.");
    }

    protected abstract String getDetails();

    @Override
    public String getInfo() {
        String details = getDetails();
        if (details == null) details = "";

        return type + "\n" +
            "Polttoaine: " + fuel + (details.isEmpty() ? "" : "\n" + details);
    }
}
