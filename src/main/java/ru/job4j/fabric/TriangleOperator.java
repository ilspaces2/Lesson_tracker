package ru.job4j.fabric;

public class TriangleOperator extends ShapeOperator {
    @Override
    public Shape createShape() {
        System.out.println("создаем треугольник со стороной 3 и высотой 3");
        return new Triangle(3, 3);
    }
}
