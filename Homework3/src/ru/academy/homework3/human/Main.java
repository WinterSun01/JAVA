package ru.academy.homework3.human;

public class Main
{
    public static void main(String[] args)
    {

        Builder builder = new Builder("Иван", 35, "Каменщик");
        Sailor sailor = new Sailor("Пётр", 40, 15);
        Pilot pilot = new Pilot("Алексей", 29, "Boeing 737");

        builder.showInfo();
        builder.work();

        System.out.println();

        sailor.showInfo();
        sailor.sail();

        System.out.println();

        pilot.showInfo();
        pilot.fly();
    }
}

