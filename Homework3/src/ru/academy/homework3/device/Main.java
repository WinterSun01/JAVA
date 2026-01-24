package ru.academy.homework3.device;

public class Main
{
    public static void main(String[] args)
    {

        Device kettle = new Kettle("Чайник", "Электрический чайник для кипячения воды");
        Device microwave = new Microwave("Микроволновка", "Разогрев пищи");
        Device car = new Car("Автомобиль", "Легковой автомобиль");
        Device steamboat = new Steamboat("Пароход", "Судно на паровом двигателе");

        kettle.Show();
        kettle.Sound();
        kettle.Desc();

        System.out.println();

        microwave.Show();
        microwave.Sound();
        microwave.Desc();

        System.out.println();

        car.Show();
        car.Sound();
        car.Desc();

        System.out.println();

        steamboat.Show();
        steamboat.Sound();
        steamboat.Desc();
    }
}

