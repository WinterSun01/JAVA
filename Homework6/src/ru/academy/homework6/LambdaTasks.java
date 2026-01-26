package ru.academy.homework6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LambdaTasks
{

    /* ================= ЗАДАНИЕ 1 ================= */

    @FunctionalInterface
    interface LeapYear
    {
        boolean isLeap(int year);
    }

    @FunctionalInterface
    interface DaysBetween
    {
        long count(LocalDate d1, LocalDate d2);
    }

    @FunctionalInterface
    interface WeeksBetween
    {
        long count(LocalDate d1, LocalDate d2);
    }

    @FunctionalInterface
    interface DayOfWeekFinder
    {
        DayOfWeek find(LocalDate date);
    }


    /* ================= ЗАДАНИЕ 2 ================= */

    @FunctionalInterface
    interface FractionOperation
    {
        double apply(double a, double b);
    }


    /* ================= ЗАДАНИЕ 3 ================= */

    @FunctionalInterface
    interface FourNumbers
    {
        int apply(int a, int b, int c, int d);
    }


    /* ================= ЗАДАНИЕ 4 ================= */

    @FunctionalInterface
    interface NumberCondition
    {
        boolean check(int value);
    }

    static int sumByCondition(int[] array, NumberCondition condition)
    {
        int sum = 0;
        for (int value : array)
        {
            if (condition.check(value))
            {
                sum += value;
            }
        }
        return sum;
    }


    /* ================= MAIN ================= */

    public static void main(String[] args)
    {

        // ---------- ЗАДАНИЕ 1 ----------

        LeapYear leapYear = year ->
                (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        System.out.println("2026 год високосный? " + leapYear.isLeap(2026));

        DaysBetween daysBetween =
                (d1, d2) -> ChronoUnit.DAYS.between(d1, d2);

        WeeksBetween weeksBetween =
                (d1, d2) -> ChronoUnit.WEEKS.between(d1, d2);

        DayOfWeekFinder dayFinder = LocalDate::getDayOfWeek;

        LocalDate date1 = LocalDate.of(2020, 1, 1);
        LocalDate date2 = LocalDate.of(2026, 1, 1);

        System.out.println("Дней между датами: " +
                daysBetween.count(date1, date2));

        System.out.println("Полных недель: " +
                weeksBetween.count(date1, date2));

        LocalDate moonLanding = LocalDate.of(1969, 7, 20);
        System.out.println("20.07.1969 — " + dayFinder.find(moonLanding));


        // ---------- ЗАДАНИЕ 2 ----------

        FractionOperation sum = (a, b) -> a + b;
        FractionOperation diff = (a, b) -> a - b;
        FractionOperation mul = (a, b) -> a * b;
        FractionOperation div = (a, b) -> a / b;

        System.out.println("Сумма дробей: " + sum.apply(2.5, 1.5));
        System.out.println("Разница дробей: " + diff.apply(2.5, 1.5));
        System.out.println("Произведение дробей: " + mul.apply(2.5, 1.5));
        System.out.println("Деление дробей: " + div.apply(2.5, 1.5));


        // ---------- ЗАДАНИЕ 3 ----------

        FourNumbers maxOfFour =
                (a, b, c, d) -> Math.max(Math.max(a, b), Math.max(c, d));

        FourNumbers minOfFour =
                (a, b, c, d) -> Math.min(Math.min(a, b), Math.min(c, d));

        System.out.println("Максимум из четырёх: " +
                maxOfFour.apply(3, 7, 1, 9));

        System.out.println("Минимум из четырёх: " +
                minOfFour.apply(3, 7, 1, 9));


        // ---------- ЗАДАНИЕ 4 ----------

        int[] numbers = { -5, -2, 0, 3, 7, 10 };

        System.out.println("Сумма чисел = 3: " +
                sumByCondition(numbers, x -> x == 3));

        int A = 0, B = 5;
        System.out.println("Не в диапазоне 0–5: " +
                sumByCondition(numbers, x -> x < A || x > B));

        System.out.println("Положительные: " +
                sumByCondition(numbers, x -> x > 0));

        System.out.println("Отрицательные: " +
                sumByCondition(numbers, x -> x < 0));
    }
}
