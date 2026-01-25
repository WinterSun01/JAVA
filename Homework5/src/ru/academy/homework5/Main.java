package ru.academy.homework5;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Dictionary dict = new Dictionary();

        dict.addWord("hello", Arrays.asList("bonjour"));
        dict.addWord("cat", Arrays.asList("chat"));
        dict.addWord("dog", Arrays.asList("chien"));

        boolean running = true;
        while (running)
        {
            System.out.println("\nМеню:");
            System.out.println("1. Показать слово");
            System.out.println("2. Добавить слово");
            System.out.println("3. Удалить слово");
            System.out.println("4. Добавить/изменить/удалить перевод");
            System.out.println("5. Топ-10 популярных слов");
            System.out.println("6. Топ-10 непопулярных слов");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1 ->
                {
                    System.out.print("Введите слово: ");
                    String word = scanner.nextLine();
                    WordEntry entry = dict.getWord(word);
                    if (entry != null) System.out.println(entry);
                    else System.out.println("Слово не найдено");
                }
                case 2 ->
                {
                    System.out.print("Введите слово: ");
                    String word = scanner.nextLine();
                    System.out.print("Введите переводы через запятую: ");
                    String[] translations = scanner.nextLine().split(",");
                    dict.addWord(word, Arrays.asList(translations));
                }
                case 3 ->
                {
                    System.out.print("Введите слово для удаления: ");
                    String word = scanner.nextLine();
                    dict.removeWord(word);
                }
                case 4 ->
                {
                    System.out.print("Введите слово: ");
                    String word = scanner.nextLine();
                    WordEntry entry = dict.getWord(word);
                    if (entry != null) {
                        System.out.println("Текущие переводы: " + entry.getTranslations());
                        System.out.println("1. Добавить перевод");
                        System.out.println("2. Изменить перевод");
                        System.out.println("3. Удалить перевод");
                        int subChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (subChoice)
                        {
                            case 1 ->
                            {
                                System.out.print("Введите новый перевод: ");
                                entry.addTranslation(scanner.nextLine());
                            }
                            case 2 ->
                            {
                                System.out.print("Введите индекс для замены: ");
                                int index = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Введите новый перевод: ");
                                entry.replaceTranslation(index, scanner.nextLine());
                            }
                            case 3 ->
                            {
                                System.out.print("Введите индекс для удаления: ");
                                int index = scanner.nextInt();
                                scanner.nextLine();
                                entry.removeTranslation(index);
                            }
                        }
                    } else
                    {
                        System.out.println("Слово не найдено");
                    }
                }
                case 5 ->
                {
                    System.out.println("Топ-10 популярных слов:");
                    for (WordEntry entry : dict.topPopular())
                    {
                        System.out.println(entry);
                    }
                }
                case 6 ->
                {
                    System.out.println("Топ-10 непопулярных слов:");
                    for (WordEntry entry : dict.topUnpopular())
                    {
                        System.out.println(entry);
                    }
                }
                case 0 -> running = false;
                default -> System.out.println("Неверный выбор");
            }
        }
        scanner.close();
    }
}

