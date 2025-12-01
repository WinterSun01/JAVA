package ru.academy.homework2;

public abstract class Shape {
    public abstract double getArea();

    public void printInfo() {
        System.out.printf("Это фигура, площадь = %.2f%n", getArea());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " с площадью " + String.format("%.2f", getArea());
    }
}