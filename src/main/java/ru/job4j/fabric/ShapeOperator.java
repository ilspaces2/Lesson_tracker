package ru.job4j.fabric;

abstract public class ShapeOperator {
    public void info() {
        Shape shape = createShape();
        System.out.println(shape.draw());
        System.out.println("Площадь " + shape.square());
    }

    public abstract Shape createShape();
}
