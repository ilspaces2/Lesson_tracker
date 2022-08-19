package ru.job4j.lombok;

public class LombokUsage {
    public static void main(String[] args) {
        Permission permission = Permission.of()
                .id(1)
                .name("Builder")
                .rules("build")
                .rules("destroy")
                .build();
        System.out.println(permission);
    }
}
