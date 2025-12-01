package ru.academy.hello.world;

public class Student extends Person{
    public Student(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Студент " + name + " говорит 'Привет!'");
    }
}
