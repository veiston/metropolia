public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Ajoneuvot (sähkö)\n");

        /* Luodaan ajoneuvot */
        AbstractVehicle car = new Car();
        AbstractVehicle motorcycle = new Motorcycle();
        AbstractVehicle bus = new Bus();
        AbstractVehicle electricCar = new ElectricCar();
        AbstractVehicle electricMotorcycle = new ElectricMotorcycle();

        /* Auto */
        car.start();
        car.stop();
        car.charge();
        System.out.println(car.getInfo());
        System.out.println();

        /* Moottoripyörä */
        motorcycle.start();
        motorcycle.stop();
        motorcycle.charge();
        System.out.println(motorcycle.getInfo());
        System.out.println();

        /* Bussi */
        bus.start();
        bus.stop();
        bus.charge();
        System.out.println(bus.getInfo());
        System.out.println();

        /* Sähköauto */
        electricCar.start();
        electricCar.stop();
        electricCar.charge();
        System.out.println(electricCar.getInfo());
        System.out.println();

        /* Sähkömoottoripyörä */
        electricMotorcycle.start();
        electricMotorcycle.stop();
        electricMotorcycle.charge();
        System.out.println(electricMotorcycle.getInfo());
    }
}
