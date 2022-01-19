package ru.job4j.oop;

public class Cat {

    private String food;

    private String name;

    public void show() {
        System.out.println(this.name + " eat " + this.food);
    }

    public void giveName(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveName("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveName("Black");
        black.eat("fish");
        black.show();
    }
}
