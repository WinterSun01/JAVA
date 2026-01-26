package ru.academy.homework7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MatchingLines
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к первому файлу: ");
        String filePath1 = scanner.nextLine();

        System.out.print("Введите путь ко второму файлу: ");
        String filePath2 = scanner.nextLine();

        BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
        BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));

        String line1;
        String line2;
        int lineNumber = 1;

        while ((line1 = reader1.readLine()) != null &&
                (line2 = reader2.readLine()) != null)
        {

            if (!line1.equals(line2))
            {
                System.out.println("Строка № " + lineNumber + " не совпадает:");
                System.out.println("Файл 1: " + line1);
                System.out.println("Файл 2: " + line2);
                System.out.println();
            }

            lineNumber++;
        }

        reader1.close();
        reader2.close();
    }
}

