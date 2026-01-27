package Task2Bus;

public class Car {
    /*Declare variables*/
    private double speed;

    /*Speksit*/
    private final double accelerationStep;
    private final double decelerationStep;
    private final double gasolineConsumption;

    public Car() {
        this(8.0, 10.0, 9.0);
    }

    protected Car(double accelerationStep, double decelerationStep, double gasolineConsumption) {
        this.speed = 0.0;
        this.accelerationStep = accelerationStep;
        this.decelerationStep = decelerationStep;
        this.gasolineConsumption = gasolineConsumption;
    }

    public double getSpeed() {
        return speed;
    }

    public double getGasolineConsumption() {
        return gasolineConsumption;
    }

    public void accelerate() {
        speed += accelerationStep;
    }

    public void decelerate() {
        speed = Math.max(0.0, speed - decelerationStep);
    }

    @Override
    public String toString() {
        return "Nopeus " + speed + " km/h, Kulutus " + gasolineConsumption + " Litraa/100km";
    }
}
