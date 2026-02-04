package Task1SportsCar;

public class CarMain {
    public static void main(String[] args) {
        /*Create car instancees*/
        Car car = new Car();
        SportsCar sportsCar = new SportsCar();

        /*Wrum wrum*/
        car.accelerate();
        car.accelerate();
        sportsCar.accelerate();
        sportsCar.accelerate();

        car.decelerate();
        sportsCar.decelerate();

        System.out.println("Paska auto (perus): " + car);
        System.out.println("Nopea auto: " + sportsCar);
    }
}
