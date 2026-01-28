package task1;

import java.util.concurrent.CountDownLatch;

class SumCalculator extends Thread
{
    private int[] array;
    private CountDownLatch latch;
    private int sum;

    public SumCalculator(int[] array, CountDownLatch latch)
    {
        this.array = array;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try {
            latch.await();
            sum = 0;
            for (int num : array)
            {
                sum += num;
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public int getSum() {
        return sum;
    }
}

