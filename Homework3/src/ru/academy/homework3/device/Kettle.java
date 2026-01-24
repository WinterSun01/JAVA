package ru.academy.homework3.device;

public class Kettle extends Device
{
    public Kettle(String name, String description)
    {
        super(name, description);
    }

    @Override
    public void Sound()
    {
        System.out.println("Чайник шумит");
    }
}

