package Task3ShapeHierarchy;

public class ShapeCalculator {
    public static void main(String[] args) {
        System.out.println("Pinta-ala-laskin");
        System.out.println();

        Shape[] shapes = new Shape[]{
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Triangle(3.0, 8.0)
        };

        /*Print geometry areas*/
        for (Shape shape : shapes) {
            System.out.println("Pinta-ala on: " + shape + ": " + shape.calculateArea());
        }
    }
}
