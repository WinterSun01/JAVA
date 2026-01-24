package ru.academy.homework3.musicalinstrument;

public class MusicalInstrument
{
    protected String name;
    protected String description;
    protected String history;

    public MusicalInstrument(String name, String description, String history)
    {
        this.name = name;
        this.description = description;
        this.history = history;
    }

    public void Sound()
    {
        System.out.println("Звук инструмента");
    }

    public void Show()
    {
        System.out.println("Инструмент: " + name);
    }

    public void Desc()
    {
        System.out.println(description);
    }

    public void History()
    {
        System.out.println(history);
    }
}

