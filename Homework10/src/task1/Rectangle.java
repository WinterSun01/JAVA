package task1;

public class Rectangle implements Shape
{

    protected double width;
    protected double height;

    public Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea()
    {
        return width * height;
    }
}

