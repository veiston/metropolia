package Task3ShapeHierarchy;

public class Shape {
    /*Declare variables*/
    private final String color;

    public Shape() {
        this(null);
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double calculateArea() {
        return 0.0;
    }
}
