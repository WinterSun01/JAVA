package ru.academy.homework1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // --------------------- ЗАДАНИЕ 11 ---------------------
    public static void drawLine(int length, char symbol, boolean vertical) {
        if (vertical) {
            for (int i = 0; i < length; i++) {
                System.out.println(symbol);
            }
        } else {
            for (int i = 0; i < length; i++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    // --------------------- ЗАДАНИЕ 12 ---------------------
    public static void sortArray(int[] array, boolean ascending) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (ascending) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                } else {
                    if (array[j] < array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // -------- ЗАДАНИЕ 1 --------
        System.out.println("Your time is limited,");
        System.out.println("so don’t waste it");
        System.out.println("living someone else’s life");
        System.out.println("Steve Jobs");

        // -------- ЗАДАНИЕ 2 --------
        System.out.print("Введите число: ");
        double number = scanner.nextDouble();

        System.out.print("Введите процент: ");
        double percent = scanner.nextDouble();

        double result = number * percent / 100;
        System.out.println(percent + "% от " + number + " = " + result);

        // -------- ЗАДАНИЕ 3 --------
        System.out.print("Введите первую цифру: ");
        int d1 = scanner.nextInt();

        System.out.print("Введите вторую цифру: ");
        int d2 = scanner.nextInt();

        System.out.print("Введите третью цифру: ");
        int d3 = scanner.nextInt();

        int resultNumber = d1 * 100 + d2 * 10 + d3;
        System.out.println("Получившееся число: " + resultNumber);

        // -------- ЗАДАНИЕ 4 --------
        System.out.print("Введите шестизначное число: ");
        String input = scanner.next();

        if (input.length() != 6) {
            System.out.println("Ошибка: нужно ввести шестизначное число!");
        } else {
            char c1 = input.charAt(0);
            char c2 = input.charAt(1);
            char c3 = input.charAt(2);
            char c4 = input.charAt(3);
            char c5 = input.charAt(4);
            char c6 = input.charAt(5);

            String swapped = "" + c6 + c5 + c3 + c4 + c2 + c1;

            System.out.println("Результат: " + swapped);
        }

        // -------- ЗАДАНИЕ 5 --------
        System.out.print("Введите номер месяца (1-12): ");
        int month = scanner.nextInt();

        if (month == 12 || month == 1 || month == 2) {
            System.out.println("Winter");
        } else if (month >= 3 && month <= 5) {
            System.out.println("Spring");
        } else if (month >= 6 && month <= 8) {
            System.out.println("Summer");
        } else if (month >= 9 && month <= 11) {
            System.out.println("Autumn");
        } else {
            System.out.println("Ошибка: такого месяца нет!");
        }

        // -------- ЗАДАНИЕ 6 --------
        System.out.print("Введите количество метров: ");
        double meters = scanner.nextDouble();

        System.out.println("Выберите вариант перевода:");
        System.out.println("1 - в мили");
        System.out.println("2 - в дюймы");
        System.out.println("3 - в ярды");

        int convChoice = scanner.nextInt();

        if (convChoice == 1) {
            System.out.println("Мили: " + meters * 0.000621371);
        } else if (convChoice == 2) {
            System.out.println("Дюймы: " + meters * 39.3701);
        } else if (convChoice == 3) {
            System.out.println("Ярды: " + meters * 1.09361);
        } else {
            System.out.println("Ошибка: неверный выбор!");
        }

        // -------- ЗАДАНИЕ 7 --------
        System.out.print("Введите первое число: ");
        int r1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int r2 = scanner.nextInt();

        if (r1 > r2) { int t = r1; r1 = r2; r2 = t; }

        System.out.println("Нечётные числа в диапазоне:");
        for (int i = r1; i <= r2; i++) {
            if (i % 2 != 0) System.out.print(i + " ");
        }
        System.out.println();

        // -------- ЗАДАНИЕ 8 --------
        System.out.print("Введите начало диапазона: ");
        int start = scanner.nextInt();

        System.out.print("Введите конец диапазона: ");
        int end = scanner.nextInt();

        if (start > end) { int t = start; start = end; end = t; }

        for (int i = start; i <= end; i++) {
            System.out.println("Таблица умножения для " + i + ":");
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
            System.out.println("----------------------");
        }

        // -------- ЗАДАНИЕ 9 --------
        System.out.print("Введите размер массива: ");
        int size9 = scanner.nextInt();

        int[] arr9 = new int[size9];

        for (int i = 0; i < size9; i++) {
            arr9[i] = (int)(Math.random() * 101) - 50;
            System.out.print(arr9[i] + " ");
        }
        System.out.println();

        int min = arr9[0];
        int max = arr9[0];
        int neg = 0, pos = 0, zero = 0;

        for (int x : arr9) {
            if (x < min) min = x;
            if (x > max) max = x;
            if (x < 0) neg++;
            else if (x > 0) pos++;
            else zero++;
        }

        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);
        System.out.println("Отрицательных: " + neg);
        System.out.println("Положительных: " + pos);
        System.out.println("Нулей: " + zero);

        // -------- ЗАДАНИЕ 10 --------
        System.out.print("Введите размер массива: ");
        int size10 = scanner.nextInt();

        int[] arr10 = new int[size10];

        for (int i = 0; i < size10; i++) {
            arr10[i] = (int)(Math.random() * 101) - 50;
            System.out.print(arr10[i] + " ");
        }
        System.out.println();

        int even = 0, odd = 0, neg2 = 0, pos2 = 0;

        for (int x : arr10) {
            if (x % 2 == 0) even++;
            else odd++;

            if (x < 0) neg2++;
            else if (x > 0) pos2++;
        }

        int[] ev = new int[even];
        int[] od = new int[odd];
        int[] ne = new int[neg2];
        int[] po = new int[pos2];

        int ei = 0, oi = 0, ni = 0, pi = 0;

        for (int x : arr10) {
            if (x % 2 == 0) ev[ei++] = x;
            else od[oi++] = x;

            if (x < 0) ne[ni++] = x;
            else if (x > 0) po[pi++] = x;
        }

        System.out.println("Чётные: " + Arrays.toString(ev));
        System.out.println("Нечётные: " + Arrays.toString(od));
        System.out.println("Отрицательные: " + Arrays.toString(ne));
        System.out.println("Положительные: " + Arrays.toString(po));
    }
}
