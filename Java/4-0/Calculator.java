public class Calculator {
    private int currentValue;

    /** Creates a calculator with value 0. */
    public Calculator() {
        reset();
    }

    /** Resets the calculator value to zero. */
    public void reset() {
        currentValue = 0;
    }

    /** Adds a positive integer to the current value. */
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative integers are not allowed");
        }
        currentValue += number;
    }

    /** Returns the current calculator value. */
    public int getValue() {
        return currentValue;
    }
}
