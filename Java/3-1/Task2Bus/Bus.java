package Task2Bus;

public class Bus extends Car {
    /*Declare variables*/
    private final int capacity;
    private int passengers;

    public Bus(int capacity) {
        super();
        this.capacity = Math.max(0, capacity);
        this.passengers = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPassengers() {
        return passengers;
    }

    public boolean passengerEnter(int count) {
        if (count <= 0) {
            return false;
        }

        if (passengers + count > capacity) {
            return false;
        }

        passengers += count;
        return true;
    }

    public boolean passengerExit(int count) {
        if (count <= 0) {
            return false;
        }

        if (passengers - count < 0) {
            return false;
        }

        passengers -= count;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", Matkustajat " + passengers + "/" + capacity;
    }
}
