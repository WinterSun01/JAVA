package ru.academy.homework3.musicalinstrument;

public class Trombone extends MusicalInstrument
{

    public Trombone()
    {
        super
                (
                    "Тромбон",
                    "Медный духовой музыкальный инструмент с кулисой",
                    "Появился в XV веке, широко используется в оркестрах"
                );
    }

    @Override
    public void Sound() {
        System.out.println("Тромбон издаёт мощный низкий звук");
    }
}

