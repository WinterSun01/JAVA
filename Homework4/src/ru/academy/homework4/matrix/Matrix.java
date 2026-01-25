package ru.academy.homework4.matrix;

import java.util.Random;
import java.util.Scanner;

public class Matrix
{
    private double[][] data;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols]; // безопасно
    }

    public void display()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //===========Заполнение матрицы с клавиатуры===========

    public void fillFromKeyboard()
    {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print("Введите элемент [" + i + "][" + j + "]: ");
                data[i][j] = scanner.nextDouble();
            }
        }
    }

    //===========Заполнение матрицы случайными числами===========

    public void fillRandom(int min, int max)
    {
        Random random = new Random();
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                data[i][j] = min + random.nextDouble() * (max - min);
            }
        }
    }

    //===========Арифметические операции===========

    // Сложение
    public Matrix add(Matrix other)
    {
        if (rows != other.rows || cols != other.cols) throw new IllegalArgumentException("Размеры не совпадают");
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.data[i][j] = this.data[i][j] + other.data[i][j];
        return result;
    }

    // Вычитание
    public Matrix subtract(Matrix other)
    {
        if (rows != other.rows || cols != other.cols) throw new IllegalArgumentException("Размеры не совпадают");
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.data[i][j] = this.data[i][j] - other.data[i][j];
        return result;
    }

    // Умножение
    public Matrix multiply(Matrix other)
    {
        if (cols != other.rows) throw new IllegalArgumentException("Несовместимые размеры");
        Matrix result = new Matrix(rows, other.cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < other.cols; j++)
                for (int k = 0; k < cols; k++)
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
        return result;
    }

    // Деление
    public Matrix divide(Matrix other)
    {
        if (rows != other.rows || cols != other.cols) throw new IllegalArgumentException("Размеры не совпадают");
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
            {
                if (other.data[i][j] == 0) throw new ArithmeticException("Деление на ноль");
                result.data[i][j] = this.data[i][j] / other.data[i][j];
            }
        return result;
    }

    //===========Поиск макс., мин. и среднее===========

    public double max()
    {
        double max = data[0][0];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (data[i][j] > max) max = data[i][j];
        return max;
    }

    public double min()
    {
        double min = data[0][0];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (data[i][j] < min) min = data[i][j];
        return min;
    }

    public double average()
    {
        double sum = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                sum += data[i][j];
        return sum / (rows * cols);
    }
}
