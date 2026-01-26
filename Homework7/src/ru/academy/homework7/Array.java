package ru.academy.homework7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Array
{
    public static void main(String[] args) throws IOException
    {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        int globalMin = Integer.MAX_VALUE;
        int globalMax = Integer.MIN_VALUE;
        int globalSum = 0;

        int arrayNumber = 1;

        while ((line = reader.readLine()) != null)
        {

            String[] parts = line.split(" ");
            int[] array = new int[parts.length];

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int sum = 0;

            for (int i = 0; i < parts.length; i++)
            {
                array[i] = Integer.parseInt(parts[i]);

                sum += array[i];
                min = Math.min(min, array[i]);
                max = Math.max(max, array[i]);
            }

            globalSum += sum;
            globalMin = Math.min(globalMin, min);
            globalMax = Math.max(globalMax, max);

            System.out.println("Массив " + arrayNumber + ": " + Arrays.toString(array));
            System.out.println("Min = " + min);
            System.out.println("Max = " + max);
            System.out.println("Sum = " + sum);
            System.out.println();

            arrayNumber++;
        }

        reader.close();

        System.out.println("ОБЩИЕ ЗНАЧЕНИЯ:");
        System.out.println("Общий минимум: " + globalMin);
        System.out.println("Общий максимум: " + globalMax);
        System.out.println("Общая сумма: " + globalSum);
    }
}

