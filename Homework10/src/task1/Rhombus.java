package task1;

public class Rhombus implements Shape
{

    private double diagonal1;
    private double diagonal2;

    public Rhombus(double diagonal1, double diagonal2)
    {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    @Override
    public double getArea()
    {
        return (diagonal1 * diagonal2) / 2;
    }
}

