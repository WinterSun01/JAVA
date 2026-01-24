package ru.academy.homework3.animal;

public class Main
{
    public static void main(String[] args)
    {

        Animal tiger = new Tiger("Амур");
        Animal crocodile = new Crocodile("Гена");
        Animal kangaroo = new Kangaroo("Джек");

        tiger.showInfo();
        crocodile.showInfo();
        kangaroo.showInfo();
    }
}

