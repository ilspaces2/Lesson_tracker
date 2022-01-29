package ru.job4j.fabric;

import java.util.Scanner;

public class CreateShapes {
    private ShapeOperator operator;

    public CreateShapes(ShapeOperator operator) {
        this.operator = operator;
    }

    public void print() {
        this.operator.info();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какую фигуру хотите создать? 1 треугольник, 2 квадрат");
        int select = scanner.nextInt();
        ShapeOperator operator = null;
        if (select == 1) {
            operator = new TriangleOperator();
        } else if (select == 2) {
            operator = new RectangleOperator();
        }
        CreateShapes createShapes = new CreateShapes(operator);
        createShapes.print();
    }
}
