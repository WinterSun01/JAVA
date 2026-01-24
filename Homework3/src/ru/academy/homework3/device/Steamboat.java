package ru.academy.homework3.device;

public class Steamboat extends Device
{
    public Steamboat (String name, String description)
    {
        super(name, description);
    }

    @Override
    public void Sound()
    {
        System.out.println("Пароход гудит");
    }
}

