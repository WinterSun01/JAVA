package ru.academy.homework3.musicalinstrument;

public class Main
{
    public static void main(String[] args)
    {

        MusicalInstrument violin = new Violin();
        MusicalInstrument trombone = new Trombone();
        MusicalInstrument ukulele = new Ukulele();
        MusicalInstrument cello = new Cello();

        violin.Show();
        violin.Sound();
        violin.Desc();
        violin.History();

        System.out.println();

        trombone.Show();
        trombone.Sound();
        trombone.Desc();
        trombone.History();

        System.out.println();

        ukulele.Show();
        ukulele.Sound();
        ukulele.Desc();
        ukulele.History();

        System.out.println();

        cello.Show();
        cello.Sound();
        cello.Desc();
        cello.History();
    }
}

