package task2;

import java.io.*;
import java.util.concurrent.CountDownLatch;

class FactorialCalculator extends Thread
{
    private String filePath;
    private CountDownLatch latch;
    private int factorialCount = 0;

    public FactorialCalculator(String filePath, CountDownLatch latch)
    {
        this.filePath = filePath;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try {
            latch.await();

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            FileWriter writer = new FileWriter("factorials.txt");

            String line;
            while ((line = reader.readLine()) != null)
            {
                int num = Integer.parseInt(line);
                writer.write(num + "! = " + factorial(num) + "\n");
                factorialCount++;
            }

            reader.close();
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private long factorial(int n)
    {
        long result = 1;
        for (int i = 1; i <= n; i++)
        {
            result *= i;
        }
        return result;
    }

    public int getFactorialCount()
    {
        return factorialCount;
    }
}
