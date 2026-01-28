package task1;

import java.util.concurrent.CountDownLatch;

class AverageCalculator extends Thread
{
    private int[] array;
    private CountDownLatch latch;
    private double average;

    public AverageCalculator(int[] array, CountDownLatch latch)
    {
        this.array = array;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try {
            latch.await();
            int sum = 0;
            for (int num : array)
            {
                sum += num;
            }
            average = (double) sum / array.length;
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public double getAverage()
    {
        return average;
    }
}

