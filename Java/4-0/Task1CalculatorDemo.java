/**
Task 1 demo for the Calculator class.
 */
public class Task1CalculatorDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.add(5);
        calculator.add(10);
        calculator.add(3);
        System.out.println("Current value: " + calculator.getValue());

        calculator.reset();
        System.out.println("After reset: " + calculator.getValue());

        try {
            calculator.add(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
