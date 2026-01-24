package ru.academy.homework3.device;

public class Microwave extends Device
{
    public Microwave(String name, String description)
    {
        super(name, description);
    }

    @Override
    public void Sound()
    {
        System.out.println("Микроволновка пищит");
    }
}

