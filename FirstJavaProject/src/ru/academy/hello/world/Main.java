package ru.academy.hello.world;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        Примитивные типы данных:

        Целые:
        byte
        short
        int
        long

        Дробные:
        float
        double

        Логические:
        boolean

        char

        Сложные объекты:
        String

         */

        int[] numbers = new int[] { 1, 2, 3 };

        for (int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i]);

        for (int number : numbers)
            System.out.println(number);

//        try (Scanner scanner = new Scanner(System.in)) {
//            System.out.println("Введите первое число:");
//            double firstNumber = scanner.nextDouble();
//
//            System.out.println("Введите второе число:");
//            double secondNumber = scanner.nextDouble();
//
//            double sum = firstNumber + secondNumber;
//            System.out.println("Сумма чисел: " + sum);
//        } catch (InputMismatchException exception) {
//            System.out.println("Введно некорректное значение!");
//        }
    }
}