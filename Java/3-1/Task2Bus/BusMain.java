package Task2Bus;

public class BusMain {
    public static void main(String[] args) {
        /*Create bus instance*/
        Bus bus = new Bus(40);

        bus.passengerEnter(12);
        bus.passengerEnter(5);
        bus.passengerExit(3);

        bus.accelerate();

        System.out.println("Bussi: " + bus);
    }
}
