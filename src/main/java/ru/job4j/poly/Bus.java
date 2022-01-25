package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Автобус принимает " + number + " пассажиров");
    }

    @Override
    public float refuel(float fuel) {
        float price = 2.45f;
        return fuel * price;
    }
}
