package task4;

import java.io.*;
import java.util.concurrent.CountDownLatch;

class FileSearchAndMerge implements Runnable
{
    private File directory;
    private String searchWord;
    private CountDownLatch latch;

    private int filesFound = 0;
    private int linesCopied = 0;

    public FileSearchAndMerge(String dirPath,
                              String searchWord,
                              CountDownLatch latch)
    {
        this.directory = new File(dirPath);
        this.searchWord = searchWord;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("merged.txt")))
        {
            search(directory, writer);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        latch.countDown();
    }

    private void search(File dir, BufferedWriter writer) throws IOException
    {
        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files)
        {
            if (file.isDirectory())
            {
                search(file, writer);
            }
            else
            {
                processFile(file, writer);
            }
        }
    }

    private void processFile(File file,
                             BufferedWriter writer) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        boolean containsWord = false;

        while ((line = reader.readLine()) != null)
        {
            if (line.contains(searchWord))
            {
                containsWord = true;
            }
        }
        reader.close();

        if (containsWord)
        {
            filesFound++;

            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null)
            {
                writer.write(line);
                writer.newLine();
                linesCopied++;
            }
            reader.close();
        }
    }

    public int getFilesFound()
    {
        return filesFound;
    }

    public int getLinesCopied()
    {
        return linesCopied;
    }
}
