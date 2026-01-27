package Task3ShapeHierarchy;

public class Triangle extends Shape {
    /*Triangle variables*/
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this(null, base, height);
    }

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return (base * height) / 2.0;
    }

    @Override
    public String toString() {
        if (getColor() == null) {
            return "Kolmio, kanta " + base + " ja korkeus " + height;
        }

        return "Kolmio, kanta " + base + " ja korkeus " + height + " (väri " + getColor() + ")";
    }
}
