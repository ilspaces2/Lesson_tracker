package ru.job4j.fabric;

public class Triangle implements Shape {
    private int a;
    private int b;

    public Triangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "   *" + ln
                + "  * *" + ln
                + " *   *" + ln
                + "*******";
    }

    @Override
    public double square() {
        return 0.5 * a * b;
    }
}
