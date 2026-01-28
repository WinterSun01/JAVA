package task4;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к директории: ");
        String dirPath = scanner.nextLine();

        System.out.print("Введите слово для поиска: ");
        String searchWord = scanner.nextLine();

        CountDownLatch latch = new CountDownLatch(1);

        FileSearchAndMerge finder =
                new FileSearchAndMerge(dirPath, searchWord, latch);

        ForbiddenWordsCleaner cleaner =
                new ForbiddenWordsCleaner("merged.txt",
                        "cleaned.txt",
                        "forbidden_words.txt",
                        latch);

        Thread searchThread = new Thread(finder);
        Thread cleanThread = new Thread(cleaner);

        searchThread.start();
        cleanThread.start();

        searchThread.join();
        cleanThread.join();

        System.out.println("\n--- Статистика ---");
        System.out.println("Найдено файлов: " + finder.getFilesFound());
        System.out.println("Скопировано строк: " + finder.getLinesCopied());
        System.out.println("Удалено запрещённых слов: " + cleaner.getRemovedWordsCount());
    }
}
