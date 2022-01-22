package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String best = "best surgeon";

    public Surgeon(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void healBody(DiagnosticCard diagnosticCard) {
        System.out.println("Hello " + diagnosticCard.getNamePacient());
        System.out.println("My name is " + getName() + " i am " + best);
        System.out.println("I repair your leg");
        diagnosticCard.getPacient().setBadLeg(false);
    }
}
