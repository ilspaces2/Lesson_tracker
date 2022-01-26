package ru.job4j.poly;

public class ElectricBus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по дорогам");
    }

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " очень тихий");
    }
}
