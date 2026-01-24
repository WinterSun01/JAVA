package ru.academy.homework3.musicalinstrument;

public class Cello extends MusicalInstrument
{

    public Cello()
    {
        super
                (
                    "Виолончель",
                    "Струнный смычковый музыкальный инструмент",
                    "Развилась в XVI веке как басовый инструмент"
                );
    }

    @Override
    public void Sound() {
        System.out.println("Виолончель издаёт глубокий бархатный звук");
    }
}

