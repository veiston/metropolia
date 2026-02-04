/* Simplified this guy. */
public class CarMain {
    public static void main(String[] args) {
        /* Create car instances*/
        Car car = new Car();

        /* Wrum wrum mf*/
        car.accelerate();
        car.accelerate();

        car.decelerate();

        System.out.println("Auto: " + car);
    }
}
