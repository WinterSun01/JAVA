package ru.academy.homework7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Array2
{
    public static void main(String[] args) throws IOException
    {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        System.out.print("Введите элементы массива через пробел: ");
        String[] parts = scanner.nextLine().split(" ");

        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
        {
            array[i] = Integer.parseInt(parts[i]);
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        writer.write(Arrays.toString(array));
        writer.newLine();

        for (int x : array)
        {
            if (x % 2 == 0)
            {
                writer.write(x + " ");
            }
        }
        writer.newLine();

        for (int x : array)
        {
            if (x % 2 != 0)
            {
                writer.write(x + " ");
            }
        }
        writer.newLine();

        for (int i = array.length - 1; i >= 0; i--)
        {
            writer.write(array[i] + " ");
        }

        writer.close();

        System.out.println("Данные успешно записаны в файл.");
    }
}

