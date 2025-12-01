package ru.academy.hello.world;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Person tom = new Student("Tom");
        tom.sayHello();

        Person bob = new Student("Bob");
        bob.sayHello();

        Person alex = new Student("Alex");
        alex.sayHello();

    }
}