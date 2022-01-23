package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String fieldOfActivity;

    public Doctor(String name, String surname, String education, String birthday, String fieldOfActivity) {
        super(name, surname, education, birthday);
        this.fieldOfActivity = fieldOfActivity;
    }

    public String getFieldOfActivity() {
        return fieldOfActivity;
    }

    public DiagnosticCard diagnostic(Pacient pacient) {
        return new DiagnosticCard(pacient);
    }
}
