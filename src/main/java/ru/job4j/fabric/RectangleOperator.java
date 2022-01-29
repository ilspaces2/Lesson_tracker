package ru.job4j.fabric;

public class RectangleOperator extends ShapeOperator {
    @Override
    public Shape createShape() {
        System.out.println("Создаем квадрат со сторонами 4 и 5");
        return new Rectangle(4, 5);
    }
}
