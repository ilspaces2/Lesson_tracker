package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private int experience = 12;

    public Dentist(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void healTooth(DiagnosticCard diagnosticCard) {
        System.out.println("Hello " + diagnosticCard.getNamePacient());
        System.out.println("My name is " + getName() + ", my experience is " + experience + " years");
        System.out.println("I fixed your tooth");
        diagnosticCard.getPacient().setBadTooth(false);
    }
}
