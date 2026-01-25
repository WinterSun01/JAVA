package ru.academy.homework4.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Array<T extends Number>
{
    private T[] elements;

    public Array(int size)
    {
        elements = (T[]) new Number[size];
    }

    public void display()
    {
        System.out.println(Arrays.toString(elements));
    }

    public void fillFromKeyboard()
    {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < elements.length; i++)
        {
            System.out.print("Введите элемент #" + i + ": ");
            double value = scanner.nextDouble();
            elements[i] = (T) Double.valueOf(value);
        }
    }

    public void fillRandom(int min, int max)
    {
        Random random = new Random();
        for (int i = 0; i < elements.length; i++)
        {
            double value = min + random.nextDouble() * (max - min);
            elements[i] = (T) Double.valueOf(value);
        }
    }

    //================Поиск максимума и минимума================

    // Максимальное значение
    public T max()
    {
        if (elements.length == 0) return null;
        T max = elements[0];
        for (T element : elements)
        {
            if (element.doubleValue() > max.doubleValue())
            {
                max = element;
            }
        }
        return max;
    }

    // Минимальное значение
    public T min()
    {
        if (elements.length == 0) return null;
        T min = elements[0];
        for (T element : elements)
        {
            if (element.doubleValue() < min.doubleValue())
            {
                min = element;
            }
        }
        return min;
    }

    //================Среднее арифметическое================

    public double average()
    {
        if (elements.length == 0) return 0;
        double sum = 0;
        for (T element : elements)
        {
            sum += element.doubleValue();
        }
        return sum / elements.length;
    }

    //================Сортировка массива================

    // По возрастанию
    public void sortAscending()
    {
        Arrays.sort(elements, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));
    }

    // По убыванию
    public void sortDescending()
    {
        Arrays.sort(elements, (a, b) -> Double.compare(b.doubleValue(), a.doubleValue()));
    }

    //================Бинарный поиск================

    public int binarySearch(T value)
    {
        sortAscending();
        int left = 0;
        int right = elements.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            double midVal = elements[mid].doubleValue();
            if (midVal == value.doubleValue()) return mid;
            if (midVal < value.doubleValue()) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    //================Замена значения================

    public void replace(T oldValue, T newValue)
    {
        for (int i = 0; i < elements.length; i++)
        {
            if (elements[i].doubleValue() == oldValue.doubleValue())
            {
                elements[i] = newValue;
            }
        }
    }
}


