package task1;

import java.util.concurrent.CountDownLatch;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {

        int[] numbers = new int[10];
        CountDownLatch latch = new CountDownLatch(1);

        Thread fillerThread = new Thread(new Filler(numbers, latch));
        SumCalculator sumThread = new SumCalculator(numbers, latch);
        AverageCalculator avgThread = new AverageCalculator(numbers, latch);

        fillerThread.start();
        sumThread.start();
        avgThread.start();

        sumThread.join();
        avgThread.join();

        System.out.print("Массив: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println("\nСумма: " + sumThread.getSum());
        System.out.println("Среднее: " + avgThread.getAverage());
    }
}

