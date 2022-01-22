package ru.job4j.inheritance;

public class Pacient {
    private String name;
    private boolean badTooth;
    private boolean badLeg;

    public Pacient(String name, boolean badTooth, boolean badLeg) {
        this.name = name;
        this.badTooth = badTooth;
        this.badLeg = badLeg;
    }

    public String getName() {
        return name;
    }

    public boolean isBadTooth() {
        return badTooth;
    }

    public boolean isBadLeg() {
        return badLeg;
    }

    public void setBadTooth(boolean badTooth) {
        this.badTooth = badTooth;
    }

    public void setBadLeg(boolean badLeg) {
        this.badLeg = badLeg;
    }
}

