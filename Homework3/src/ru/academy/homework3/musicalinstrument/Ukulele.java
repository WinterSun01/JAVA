package ru.academy.homework3.musicalinstrument;

public class Ukulele extends MusicalInstrument
{

    public Ukulele()
    {
        super
                (
                    "Укулеле",
                    "Небольшой струнный щипковый инструмент",
                    "Появился на Гавайях в XIX веке"
                );
    }

    @Override
    public void Sound() {
        System.out.println("Укулеле звучит мягко и весело");
    }
}

