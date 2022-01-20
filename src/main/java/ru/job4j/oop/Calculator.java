package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int z) {
        return sum(z) + minus(z) + multiply(z) + divide(z);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = sum(12);
        System.out.println("Sum: " + result);
        result = calculator.multiply(5);
        System.out.println("Mult: " + result);
        result = minus(2);
        System.out.println("Minus: " + result);
        result = calculator.divide(5);
        System.out.println("Div: " + result);
        result = calculator.sumAllOperation(10);
        System.out.println("All: " + result);
    }
}