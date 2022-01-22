package ru.job4j.inheritance;

public class TechnicalTask {
    private String name;
    private String description;
    private int id;

    public TechnicalTask(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
