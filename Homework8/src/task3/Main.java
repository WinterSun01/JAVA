package task3;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к существующей директории: ");
        String sourceDir = scanner.nextLine();

        System.out.print("Введите путь к новой директории: ");
        String targetDir = scanner.nextLine();

        DirectoryCopier copier = new DirectoryCopier(sourceDir, targetDir);
        Thread copyThread = new Thread(copier);

        long startTime = System.currentTimeMillis();

        copyThread.start();
        copyThread.join();

        long endTime = System.currentTimeMillis();

        System.out.println("\n--- Статистика ---");
        System.out.println("Скопировано файлов: " + copier.getFilesCopied());
        System.out.println("Создано директорий: " + copier.getDirsCreated());
        System.out.println("Время выполнения (мс): " + (endTime - startTime));
    }
}
