package ru.academy.homework5;

import java.util.*;

public class Dictionary
{
    private Map<String, WordEntry> words;

    public Dictionary()
    {
        words = new HashMap<>();
    }

    // Добавить новое слово
    public void addWord(String word, List<String> translations)
    {
        WordEntry entry = new WordEntry(word);
        for (String t : translations)
        {
            entry.addTranslation(t);
        }
        words.put(word, entry);
    }

    // Получить слово и увеличить счетчик
    public WordEntry getWord(String word)
    {
        WordEntry entry = words.get(word);
        if (entry != null)
        {
            entry.incrementCounter();
        }
        return entry;
    }

    // Удалить слово
    public void removeWord(String word)
    {
        words.remove(word);
    }

    // Заменить слово
    public void replaceWord(String oldWord, String newWord)
    {
        WordEntry entry = words.get(oldWord);
        if (entry != null) {
            words.remove(oldWord);
            entry = new WordEntry(newWord);
            words.put(newWord, entry);
        }
    }

    // Топ-10 популярных слов
    public List<WordEntry> topPopular()
    {
        return words.values().stream()
                .sorted((a, b) -> b.getCounter() - a.getCounter())
                .limit(10)
                .toList();
    }

    // Топ-10 непопулярных слов
    public List<WordEntry> topUnpopular()
    {
        return words.values().stream()
                .sorted(Comparator.comparingInt(WordEntry::getCounter))
                .limit(10)
                .toList();
    }

    // Отобразить все слова
    public void printAll()
    {
        for (WordEntry entry : words.values())
        {
            System.out.println(entry);
        }
    }
}

