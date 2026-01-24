package ru.academy.homework3.musicalinstrument;

public class Violin extends MusicalInstrument
{
    public Violin()
    {
        super
                (
                    "Скрипка",
                    "Струнный смычковый инструмент",
                    "Появилась в XVI веке в Италии"
                );
    }

    @Override
    public void Sound() {
        System.out.println("Скрипка издает нежный звук");
    }
}

