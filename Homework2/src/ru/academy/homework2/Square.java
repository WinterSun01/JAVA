package ru.academy.homework2;

public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Квадрат, площадь = " + String.format("%.2f", getArea());
    }
}