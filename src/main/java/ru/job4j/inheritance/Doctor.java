package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String fieldOfActivity = "Heal people";

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public String getFieldOfActivity() {
        return fieldOfActivity;
    }

    public DiagnosticCard diagnostic(Pacient pacient) {
        return new DiagnosticCard(pacient);
    }
}
