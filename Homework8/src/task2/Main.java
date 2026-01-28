package task2;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        CountDownLatch latch = new CountDownLatch(1);

        FileFiller filler = new FileFiller(filePath, latch);
        PrimeFinder primeFinder = new PrimeFinder(filePath, latch);
        FactorialCalculator factorialCalculator = new FactorialCalculator(filePath, latch);

        Thread fillerThread = new Thread(filler);

        fillerThread.start();
        primeFinder.start();
        factorialCalculator.start();

        primeFinder.join();
        factorialCalculator.join();

        System.out.println("\n--- Статистика ---");
        System.out.println("Чисел записано: " + filler.getCount());
        System.out.println("Простых чисел найдено: " + primeFinder.getPrimeCount());
        System.out.println("Факториалов вычислено: " + factorialCalculator.getFactorialCount());
    }
}
