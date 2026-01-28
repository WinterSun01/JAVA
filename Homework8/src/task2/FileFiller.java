package task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

class FileFiller implements Runnable
{
    private String filePath;
    private CountDownLatch latch;
    private int count = 20;

    public FileFiller(String filePath, CountDownLatch latch)
    {
        this.filePath = filePath;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        Random random = new Random();

        try (FileWriter writer = new FileWriter(filePath))
        {
            for (int i = 0; i < count; i++)
            {
                int number = random.nextInt(10) + 1;
                writer.write(number + "\n");
            }
            System.out.println("Файл заполнен числами.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        latch.countDown();
    }

    public int getCount()
    {
        return count;
    }
}
