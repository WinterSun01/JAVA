package ru.academy.homework2;

public class Main {
    public static void main(String[] args) {

        Shape square = new Square(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape circle = new Circle(3);

        System.out.println("Площадь квадрата: " + square.getArea());
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());
        System.out.println("Площадь круга: " + circle.getArea());

        System.out.println();

        Shape[] shapes = {square, rectangle, circle};

        for (Shape s : shapes) {
            System.out.println(s);
        }
    }
}
