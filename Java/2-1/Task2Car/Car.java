public class Car {
    /* Declare variables*/
    private double speed;
    private double gasolineTankCapacity;

    /* Speksit*/
    private final double accelerationStep;
    private final double decelerationStep;
    private final double gasolineConsumption;

    public Car() {
        this(10.0, 10.0, 7.0);
    }

    public Car(double gasolineTankCapacity, double speed) {
        this(10.0, 10.0, 7.0);
        this.gasolineTankCapacity = Math.max(0.0, gasolineTankCapacity);
        this.speed = Math.max(0.0, speed);
    }

    protected Car(double accelerationStep, double decelerationStep, double gasolineConsumption) {
        this.speed = 0.0;
        this.gasolineTankCapacity = 0.0;
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

    public double getGasolineTankCapacity() {
        return gasolineTankCapacity;
    }

    public void accelerate() {
        speed += accelerationStep;
    }

    public void decelerate() {
        speed = Math.max(0.0, speed - decelerationStep);
    }

    public String toString() {
        return "Nopeus " + speed + " km/h, Kulutus " + gasolineConsumption + " L/100km";
    }
}
