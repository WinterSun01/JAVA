package ru.academy.homework3.device;

public class Device
{
    protected String name;
    protected String description;

    public Device(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public void Sound()
    {
        System.out.println("Устройство издаёт звук");
    }

    public void Show()
    {
        System.out.println("Устройство: " + name);
    }

    public void Desc()
    {
        System.out.println(description);
    }
}

