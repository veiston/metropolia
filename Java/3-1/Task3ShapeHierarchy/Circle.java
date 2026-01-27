package Task3ShapeHierarchy;

public class Circle extends Shape {
    /*Declare varibales*/
    private final double radius;

    public Circle(double radius) {
        this(null, radius);
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        if (getColor() == null) {
            return "Ympyrä, säde " + radius;
        }

        return "Ympyrä, säde " + radius + " (väri " + getColor() + ")";
    }
}
