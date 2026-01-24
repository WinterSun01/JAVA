package ru.academy.homework3.device;

public class Car extends Device
{
    public Car (String name, String description)
    {
        super(name, description);
    }

    @Override
    public void Sound()
    {
        System.out.println("Автомобиль сигналит");
    }
}

