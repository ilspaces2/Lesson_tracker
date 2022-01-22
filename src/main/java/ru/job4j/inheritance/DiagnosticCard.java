package ru.job4j.inheritance;

public class DiagnosticCard {
    private String namePacient;
    private boolean checkTooth;
    private boolean checkBody;
    private Pacient pacient;

    public DiagnosticCard(Pacient pacient) {
        this.pacient = pacient;
        namePacient = pacient.getName();
        checkBody = pacient.isBadLeg();
        checkTooth = pacient.isBadTooth();
    }

    public Pacient getPacient() {
        return pacient;
    }

    public String getNamePacient() {
        return namePacient;
    }

    public boolean isCheckTooth() {
        return checkTooth;
    }

    public boolean isCheckBody() {
        return checkBody;
    }

}
