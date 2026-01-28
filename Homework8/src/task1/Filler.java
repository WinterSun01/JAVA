package task1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

class Filler implements Runnable
{
    private int[] array;
    private CountDownLatch latch;

    public Filler(int[] array, CountDownLatch latch)
    {
        this.array = array;
        this.latch = latch;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++)
        {
            array[i] = random.nextInt(100);
        }
        System.out.println("Массив заполнен!");

        latch.countDown();
    }
}
