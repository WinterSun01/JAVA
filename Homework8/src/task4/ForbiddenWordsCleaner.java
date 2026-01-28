package task4;

import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

class ForbiddenWordsCleaner extends Thread
{
    private String inputFile;
    private String outputFile;
    private String forbiddenFile;
    private CountDownLatch latch;

    private int removedWordsCount = 0;

    public ForbiddenWordsCleaner(String inputFile,
                                 String outputFile,
                                 String forbiddenFile,
                                 CountDownLatch latch)
    {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.forbiddenFile = forbiddenFile;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try {
            latch.await();

            Set<String> forbiddenWords = loadForbiddenWords();

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null)
            {
                for (String word : forbiddenWords)
                {
                    if (line.contains(word))
                    {
                        removedWordsCount++;
                        line = line.replace(word, "***");
                    }
                }
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private Set<String> loadForbiddenWords() throws IOException
    {
        Set<String> words = new HashSet<>();
        BufferedReader reader =
                new BufferedReader(new FileReader(forbiddenFile));

        String line;
        while ((line = reader.readLine()) != null)
        {
            words.add(line.trim());
        }
        reader.close();
        return words;
    }

    public int getRemovedWordsCount()
    {
        return removedWordsCount;
    }
}
