public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Ajoneuvot. Tehokkuus\n");

        Vehicle[] vehicles = {
                new Car(),
                new Motorcycle(),
                new Bus(),
                new ElectricCar(),
                new ElectricMotorcycle()
        };

        for (Vehicle v : vehicles) {
            v.start();
            v.stop();
            v.charge();
            System.out.println(v.getInfo());
            System.out.println("Tehokkuus: " + v.calculateFuelEfficiency());
            System.out.println();
        }
    }
}

interface Vehicle {
    void start();

    void stop();

    void charge();

    String getInfo();

    double calculateFuelEfficiency();
}

abstract class AbstractVehicle implements Vehicle {
    private final String type;
    private final String fuel;
    private final double efficiency;

    protected AbstractVehicle(String type, String fuel, double efficiency) {
        this.type = type;
        this.fuel = fuel;
        this.efficiency = efficiency;
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

    public double calculateFuelEfficiency() {
        return efficiency;
    }

    protected abstract String getDetails();

    public String getInfo() {
        String details = getDetails();
        if (details == null) details = "";

        return type + "\n" +
                "Polttoaine: " + fuel +
                (details.isEmpty() ? "" : "\n" + details);
    }
}

class Car extends AbstractVehicle {
    public Car() {
        super("Auto", "Bensiini", 6.5);
    }

    protected String getDetails() {
        return "Väri: Punainen";
    }
}

class Motorcycle extends AbstractVehicle {
    public Motorcycle() {
        super("Moottoripyörä", "Bensiini", 4.2);
    }

    protected String getDetails() {
        return "Väri: Musta";
    }
}

class Bus extends AbstractVehicle {
    public Bus() {
        super("Bussi", "Diesel", 25.0);
    }

    protected String getDetails() {
        return "Kapasiteetti: 40";
    }
}

class ElectricCar extends AbstractVehicle {
    public ElectricCar() {
        super("Sähköauto", "Sähkö", 0.18);
    }

    public void charge() {
        System.out.println("Sähköauto lataa...");
    }

    protected String getDetails() {
        return "Väri: Sininen";
    }
}

class ElectricMotorcycle extends AbstractVehicle {
    public ElectricMotorcycle() {
        super("Sähkömoottoripyörä", "Sähkö", 0.09);
    }

    public void charge() {
        System.out.println("Sähkömoottoripyörä lataa...");
    }

    protected String getDetails() {
        return "Väri: Valkoinen";
    }
}
