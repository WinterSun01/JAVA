package ru.academy.homework3.human;

public class Human
{
    protected String name;
    protected int age;

    public Human(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void showInfo()
    {
        System.out.println("Имя: " + name + ", возраст: " + age);
    }
}

