package ru.academy.homework9;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {

        ArrayList<Car> cars = new ArrayList<>();

        cars.add(new Car("Toyota Camry", 2018, 25000, "Белый"));
        cars.add(new Car("BMW X5", 2020, 60000, "Чёрный"));
        cars.add(new Car("Lada Granta", 2015, 8000, "Белый"));
        cars.add(new Car("Audi A6", 2019, 45000, "Синий"));
        cars.add(new Car("Tesla Model 3", 2022, 50000, "Красный"));

        showAllCars(cars);
        showCarsByColor(cars, "Белый");
        showCarsMoreExpensiveThan(cars, 40000);
        showCarsByYearRange(cars, 2018, 2022);
    }

    //Показать все автомобили
    public static void showAllCars(ArrayList<Car> cars)
    {
        System.out.println("\nВсе автомобили:");
        for (Car car : cars)
        {
            car.printInfo();
        }
    }

    //Показать авто заданного цвета
    public static void showCarsByColor(ArrayList<Car> cars, String color)
    {
        System.out.println("\nАвтомобили цвета: " + color);
        for (Car car : cars)
        {
            if (car.color.equalsIgnoreCase(color))
            {
                car.printInfo();
            }
        }
    }

    //Показать авто дороже заданной цены
    public static void showCarsMoreExpensiveThan(ArrayList<Car> cars, double price)
    {
        System.out.println("\nАвтомобили дороже " + price);
        for (Car car : cars)
        {
            if (car.price > price)
            {
                car.printInfo();
            }
        }
    }

    //Показать авто по диапазону года выпуска
    public static void showCarsByYearRange(ArrayList<Car> cars, int fromYear, int toYear)
    {
        System.out.println("\nАвтомобили с " + fromYear + " по " + toYear);
        for (Car car : cars)
        {
            if (car.year >= fromYear && car.year <= toYear)
            {
                car.printInfo();
            }
        }
    }
}


