package Task4ShapeProperties;

import Task3ShapeHierarchy.Circle;
import Task3ShapeHierarchy.Rectangle;
import Task3ShapeHierarchy.Shape;
import Task3ShapeHierarchy.Triangle;

public class ShapeCalculator {
    public static void main(String[] args) {
        System.out.println("Muoto laskin");
        System.out.println();

        /*Create shape instances*/
        Shape[] shapes = new Shape[]{
                new Circle("punainen", 5.0),
                new Rectangle("sininen", 4.0, 6.0),
                new Triangle("vihreä", 3.0, 8.0)
        };

        for (Shape shape : shapes) {
            System.out.println("Pinta-ala, " + shape + ": " + shape.calculateArea());
        }
    }
}
