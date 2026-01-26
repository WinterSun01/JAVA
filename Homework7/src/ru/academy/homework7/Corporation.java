package ru.academy.homework7;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Corporation
{
    static class Employee
    {
        private String firstName;
        private String lastName;
        private int age;

        public Employee(String firstName, String lastName, int age)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public int getAge() { return age; }

        public void setFirstName(String firstName) { this.firstName = firstName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public void setAge(int age) { this.age = age; }

        @Override
        public String toString()
        {
            return firstName + " " + lastName + ", возраст: " + age;
        }
    }

    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к текстовому файлу сотрудников: ");
        String filePath = scanner.nextLine();

        loadFromFileText(filePath);

        while (true)
        {
            System.out.println("""
            
            ===== МЕНЮ =====
            1. Добавить сотрудника
            2. Редактировать сотрудника
            3. Удалить сотрудника
            4. Поиск по фамилии
            5. Фильтр по возрасту или букве
            6. Показать всех сотрудников
            7. Сохранить и выйти
            """);

            System.out.print("Выберите пункт: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1 -> addEmployee(scanner);
                case 2 -> editEmployee(scanner);
                case 3 -> removeEmployee(scanner);
                case 4 -> searchByLastName(scanner);
                case 5 -> filter(scanner);
                case 6 -> showAll();
                case 7 ->
                {
                    saveToFileText(filePath);
                    System.out.println("Данные сохранены. Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный пункт меню.");
            }
        }
    }

    // ===== ДОБАВЛЕНИЕ =====
    static void addEmployee(Scanner scanner)
    {
        System.out.print("Имя: ");
        String firstName = scanner.nextLine();

        System.out.print("Фамилия: ");
        String lastName = scanner.nextLine();

        System.out.print("Возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        employees.add(new Employee(firstName, lastName, age));
        System.out.println("Сотрудник добавлен.");
    }

    // ===== РЕДАКТИРОВАНИЕ =====
    static void editEmployee(Scanner scanner)
    {
        System.out.print("Введите фамилию сотрудника для редактирования: ");
        String lastName = scanner.nextLine();

        for (Employee e : employees)
        {
            if (e.getLastName().equalsIgnoreCase(lastName))
            {
                System.out.print("Новое имя: ");
                e.setFirstName(scanner.nextLine());

                System.out.print("Новая фамилия: ");
                e.setLastName(scanner.nextLine());

                System.out.print("Новый возраст: ");
                e.setAge(scanner.nextInt());
                scanner.nextLine();

                System.out.println("Данные обновлены.");
                return;
            }
        }
        System.out.println("Сотрудник не найден.");
    }

    // ===== УДАЛЕНИЕ =====
    static void removeEmployee(Scanner scanner)
    {
        System.out.print("Введите фамилию для удаления: ");
        String lastName = scanner.nextLine();

        boolean removed = employees.removeIf(
                e -> e.getLastName().equalsIgnoreCase(lastName)
        );

        if (removed)
        {
            System.out.println("Сотрудник удалён.");
        } else
        {
            System.out.println("Сотрудник не найден.");
        }
    }

    // ===== ПОИСК =====
    static void searchByLastName(Scanner scanner)
    {
        System.out.print("Введите фамилию для поиска: ");
        String lastName = scanner.nextLine();

        boolean found = false;
        for (Employee e : employees)
        {
            if (e.getLastName().equalsIgnoreCase(lastName))
            {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("Сотрудник не найден.");
    }

    // ===== ФИЛЬТР =====
    static void filter(Scanner scanner)
    {
        System.out.print("Введите возраст или начальную букву фамилии: ");
        String input = scanner.nextLine();

        boolean found = false;
        for (Employee e : employees)
        {
            if (input.matches("\\d+"))
            {
                if (e.getAge() == Integer.parseInt(input))
                {
                    System.out.println(e);
                    found = true;
                }
            } else
            {
                if (e.getLastName().startsWith(input))
                {
                    System.out.println(e);
                    found = true;
                }
            }
        }
        if (!found) System.out.println("Сотрудники не найдены.");
    }

    // ===== ПОКАЗАТЬ ВСЕХ =====
    static void showAll()
    {
        if (employees.isEmpty())
        {
            System.out.println("Список сотрудников пуст.");
            return;
        }

        for (Employee e : employees)
        {
            System.out.println(e);
        }
    }

    // ===== СОХРАНЕНИЕ В ТЕКСТ =====
    static void saveToFileText(String filePath)
    {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8")))
        {
            for (Employee e : employees)
            {
                writer.write(e.getFirstName() + "," + e.getLastName() + "," + e.getAge());
                writer.newLine();
            }
        } catch (IOException e)
        {
            System.out.println("Ошибка сохранения файла.");
        }
    }

    // ===== ЗАГРУЗКА ИЗ ТЕКСТА =====
    static void loadFromFileText(String filePath)
    {
        File file = new File(filePath);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8")))
        {
            employees.clear();
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length != 3) continue;
                employees.add(new Employee(parts[0], parts[1], Integer.parseInt(parts[2])));
            }
        } catch (Exception e)
        {
            System.out.println("Ошибка загрузки файла.");
        }
    }
}


