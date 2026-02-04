public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Ajoneuvot (abstract)\n");

        /* Luodaan ajoneuvot */
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();
        Vehicle bus = new Bus();

        /* Auto */
        car.start();
        car.stop();
        System.out.println(car.getInfo());
        System.out.println();

        /* Moottoripyörä */
        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo());
        System.out.println();

        /* Bussi */
        bus.start();
        bus.stop();
        System.out.println(bus.getInfo());
    }
}
