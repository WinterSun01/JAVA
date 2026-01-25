package ru.academy.homework5;

import java.util.ArrayList;
import java.util.List;

public class WordEntry
{
    private String word;
    private List<String> translations;
    private int counter;

    public WordEntry(String word)
    {
        this.word = word;
        this.translations = new ArrayList<>();
        this.counter = 0;
    }

    public String getWord()
    {
        return word;
    }

    public List<String> getTranslations()
    {
        return translations;
    }

    public int getCounter()
    {
        return counter;
    }

    public void incrementCounter()
    {
        counter++;
    }

    public void addTranslation(String translation)
    {
        translations.add(translation);
    }

    public void replaceTranslation(int index, String newTranslation)
    {
        if (index >= 0 && index < translations.size())
        {
            translations.set(index, newTranslation);
        }
    }

    public void removeTranslation(int index)
    {
        if (index >= 0 && index < translations.size())
        {
            translations.remove(index);
        }
    }

    @Override
    public String toString()
    {
        return word + " -> " + translations + " (использований: " + counter + ")";
    }
}

