package Task3ShapeHierarchy;

public class Rectangle extends Shape {
    /*Declare variables*/
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this(null, width, height);
    }

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String toString() {
        if (getColor() == null) {
            return "Suorakulmio, leveys " + width + " ja korkeus " + height;
        }

        return "Suorakulmio, leveys " + width + " ja korkeus " + height + " (väri " + getColor() + ")";
    }
}
