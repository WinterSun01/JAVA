package task2;

import java.io.*;
import java.util.concurrent.CountDownLatch;

class PrimeFinder extends Thread
{
    private String filePath;
    private CountDownLatch latch;
    private int primeCount = 0;

    public PrimeFinder(String filePath, CountDownLatch latch)
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
            FileWriter writer = new FileWriter("primes.txt");

            String line;
            while ((line = reader.readLine()) != null)
            {
                int num = Integer.parseInt(line);
                if (isPrime(num))
                {
                    writer.write(num + "\n");
                    primeCount++;
                }
            }

            reader.close();
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private boolean isPrime(int n)
    {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int getPrimeCount()
    {
        return primeCount;
    }
}
