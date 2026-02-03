import Task1SportsCar.Car;
import Task1SportsCar.SportsCar;

public class CarMain {
    public static void main(String[] args) {
        /* Create car instances*/
        Car car = new Car();
        SportsCar sportsCar = new SportsCar();

        /* Wrum wrum mf*/
        car.accelerate();
        car.accelerate();
        sportsCar.accelerate();
        sportsCar.accelerate();

        car.decelerate();
        sportsCar.decelerate();

        System.out.println("Perus: " + car);
        System.out.println("Nopea auto: " + sportsCar);
    }
}
