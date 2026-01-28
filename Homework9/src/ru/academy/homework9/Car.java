package ru.academy.homework9;

public class Car
{

    String name;
    int year;
    double price;
    String color;

    public Car(String name, int year, double price, String color)
    {
        this.name = name;
        this.year = year;
        this.price = price;
        this.color = color;
    }

    public void printInfo()
    {
        System.out.println
                (
                        "Название: " + name +
                        ", Год: " + year +
                        ", Цена: " + price +
                        ", Цвет: " + color
                );
    }
}

