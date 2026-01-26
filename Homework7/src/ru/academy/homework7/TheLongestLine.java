package ru.academy.homework7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TheLongestLine
{
    public static void main(String[] args) throws IOException
    {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        String longestLine = "";
        int maxLength = 0;

        while ((line = reader.readLine()) != null)
        {

            if (line.length() > maxLength)
            {
                maxLength = line.length();
                longestLine = line;
            }
        }

        reader.close();

        System.out.println("Длина самой длинной строки: " + maxLength);
        System.out.println("Сама строка:");
        System.out.println(longestLine);
    }
}

