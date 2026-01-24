package ru.academy.homework3.human;

public class Sailor extends Human
{
    private int experienceYears;

    public Sailor(String name, int age, int experienceYears)
    {
        super(name, age);
        this.experienceYears = experienceYears;
    }

    public void sail()
    {
        System.out.println("Моряк в море. Стаж: " + experienceYears + " лет");
    }
}

