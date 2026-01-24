package ru.academy.homework3.human;

public class Builder extends Human
{
    private String specialization;

    public Builder(String name, int age, String specialization)
    {
        super(name, age);
        this.specialization = specialization;
    }

    public void work()
    {
        System.out.println("Строитель работает. Специализация: " + specialization);
    }
}

