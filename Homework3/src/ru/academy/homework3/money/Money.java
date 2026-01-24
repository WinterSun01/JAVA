package ru.academy.homework3.money;

public class Money
{
    protected int units;   // рубли, доллары
    protected int cents;   // копейки, центы

    public Money(int units, int cents)
    {
        this.units = units;
        this.cents = cents;
        normalize();
    }

    protected void normalize()
    {
        if (cents >= 100)
        {
            units += cents / 100;
            cents = cents % 100;
        }
    }

    public void setMoney(int units, int cents)
    {
        this.units = units;
        this.cents = cents;
        normalize();
    }

    public void show()
    {
        System.out.println("Сумма: " + units + "." + cents);
    }
}

