package ru.job4j.poly;

public class Vehicles {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle electricBus = new ElectricBus();

        Vehicle[] transports = new Vehicle[]{airplane, train, electricBus};
        for (Vehicle transport : transports) {
            transport.move();
            transport.sound();
            System.out.println();
        }

    }
}
