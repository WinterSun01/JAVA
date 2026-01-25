package ru.academy.homework4.array;

public class Main
{
    public static void main(String[] args)
    {
        Array<Double> arr = new Array<>(5);

        System.out.println("Заполнение случайными числами:");
        arr.fillRandom(0, 100);
        arr.display();

        System.out.println("Максимум: " + arr.max());
        System.out.println("Минимум: " + arr.min());
        System.out.println("Среднее: " + arr.average());

        System.out.println("Сортировка по возрастанию:");
        arr.sortAscending();
        arr.display();

        System.out.println("Сортировка по убыванию:");
        arr.sortDescending();
        arr.display();

        System.out.println("Бинарный поиск значения 50:");
        int index = arr.binarySearch(50.0);
        System.out.println("Индекс: " + index);

        System.out.println("Замена значения 50 на 99:");
        arr.replace(50.0, 99.0);
        arr.display();
    }
}

