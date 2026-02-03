package task1;

public class Main
{
    public static void main(String[] args)
    {

        Shape triangle = new Triangle(10, 5);
        Shape rectangle = new Rectangle(4, 6);
        Shape square = new Square(5);
        Shape rhombus = new Rhombus(8, 6);

        System.out.println("Triangle area: " + triangle.getArea());
        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Square area: " + square.getArea());
        System.out.println("Rhombus area: " + rhombus.getArea());
    }
}

