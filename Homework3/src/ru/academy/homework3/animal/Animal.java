package ru.academy.homework3.animal;

public class Animal
{
    protected String name;
    protected String characteristic;

    public Animal(String name, String characteristic)
    {
        this.name = name;
        this.characteristic = characteristic;
    }

    public void showInfo()
    {
        System.out.println(name + ": " + characteristic);
    }
}

