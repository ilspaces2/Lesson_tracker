package ru.job4j.inheritance;

public class Doctor extends Profession {

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public DiagnosticCard diagnostic(Pacient pacient) {
        return new DiagnosticCard(pacient);
    }
}
