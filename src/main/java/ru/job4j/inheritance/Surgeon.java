package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String best;

    public Surgeon(String name, String surname, String education, String birthday, String fieldOfActivity, String best) {
        super(name, surname, education, birthday, fieldOfActivity);
        this.best = best;
    }

    public String getBest() {
        return best;
    }

    public void healBody(DiagnosticCard diagnosticCard) {
        System.out.println("Hello " + diagnosticCard.getNamePacient());
        System.out.println("My name is " + getName() + " i am " + best);
        System.out.println("I repair your leg");
        diagnosticCard.getPacient().setBadLeg(false);
    }
}
