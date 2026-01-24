package ru.academy.homework3.money;

public class Product extends Money
{
    private String name;

    public Product(String name, int units, int cents)
    {
        super(units, cents);
        this.name = name;
    }

    public void reducePrice(int reduceUnits, int reduceCents)
    {
        int totalCents = units * 100 + cents;
        int reduceTotal = reduceUnits * 100 + reduceCents;

        totalCents -= reduceTotal;
        if (totalCents < 0) totalCents = 0;

        units = totalCents / 100;
        cents = totalCents % 100;
    }

    public void showProduct()
    {
        System.out.println("Товар: " + name);
        show();
    }
}

