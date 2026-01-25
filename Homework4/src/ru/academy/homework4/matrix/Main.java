package ru.academy.homework4.matrix;

public class Main
{
    public static void main(String[] args)
    {
        Matrix mat1 = new Matrix(2, 2); // убрали <Double>
        Matrix mat2 = new Matrix(2, 2);

        mat1.fillRandom(0, 10);
        mat2.fillRandom(0, 10);

        System.out.println("Матрица 1:");
        mat1.display();

        System.out.println("Матрица 2:");
        mat2.display();

        System.out.println("Сложение матриц:");
        Matrix sum = mat1.add(mat2); // теперь просто Matrix
        sum.display();

        System.out.println("Вычитание матриц:");
        Matrix diff = mat1.subtract(mat2);
        diff.display();

        System.out.println("Умножение матриц:");
        Matrix prod = mat1.multiply(mat2);
        prod.display();

        System.out.println("Деление матриц (поэлементное):");
        Matrix div = mat1.divide(mat2);
        div.display();

        System.out.println("Максимум матрицы 1: " + mat1.max());
        System.out.println("Минимум матрицы 1: " + mat1.min());
        System.out.println("Среднее матрицы 1: " + mat1.average());
    }
}
