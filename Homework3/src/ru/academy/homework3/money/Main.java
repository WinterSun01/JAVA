package ru.academy.homework3.money;

public class Main
{
    public static void main(String[] args)
    {

        Product bread = new Product("Хлеб", 1, 50);

        bread.showProduct();
        bread.reducePrice(0, 70);

        System.out.println("После скидки:");
        bread.showProduct();
    }
}

