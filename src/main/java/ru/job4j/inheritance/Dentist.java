package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private int experience;

    public Dentist(String name, String surname, String education, String birthday, String fieldOfActivity, int experience) {
        super(name, surname, education, birthday, fieldOfActivity);
        this.experience = experience;
    }

    public void healTooth(DiagnosticCard diagnosticCard) {
        System.out.println("Hello " + diagnosticCard.getNamePacient());
        System.out.println("My name is " + getName() + ", my experience is " + experience + " years");
        System.out.println("I fixed your tooth");
        diagnosticCard.getPacient().setBadTooth(false);
    }
}
