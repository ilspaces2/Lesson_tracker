package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает");
    }

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " издает громкий звук");
    }
}
