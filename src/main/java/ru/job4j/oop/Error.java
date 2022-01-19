package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String massage;

    public Error() {
    }

    public Error(boolean active, int status, String massage) {
        this.active = active;
        this.status = status;
        this.massage = massage;
    }

    public void print() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Massage: " + massage);
    }

    public static void main(String[] args) {
        Error one = new Error();
        Error two = new Error(false, 404, "Disconnect");
        Error three = new Error(true, 200, "Connect");
        one.print();
        System.out.println("---");
        two.print();
        System.out.println("---");
        three.print();
    }
}
