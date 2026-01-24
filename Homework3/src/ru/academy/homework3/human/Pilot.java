package ru.academy.homework3.human;

public class Pilot extends Human
{
    private String aircraftType;

    public Pilot(String name, int age, String aircraftType)
    {
        super(name, age);
        this.aircraftType = aircraftType;
    }

    public void fly()
    {
        System.out.println("Лётчик управляет самолётом: " + aircraftType);
    }
}

