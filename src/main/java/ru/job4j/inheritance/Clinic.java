package ru.job4j.inheritance;

public class Clinic {
    public static void main(String[] args) {
        Pacient firstPacient = new Pacient("Tom", true, false);
        Dentist dentist = new Dentist("loo", "Cooper", "Master", "09.09.1980", "Heal teeth", 10);
        DiagnosticCard diagnosticCard = dentist.diagnostic(firstPacient);
        if (diagnosticCard.isCheckTooth()) {
            dentist.healTooth(diagnosticCard);
        } else {
            System.out.println("Your tooth is good. Go home");
        }
        System.out.println("-------");
        Surgeon surgeon = new Surgeon("Joe", "Smith", "Professor", "10.10.1970", "Heal injuries", "Best surgeon");
        Pacient secondPacient = new Pacient("Jerry", false, true);
        DiagnosticCard diagnosticCardTwo = surgeon.diagnostic(secondPacient);
        if (diagnosticCardTwo.isCheckBody()) {
            surgeon.healBody(diagnosticCardTwo);
        } else {
            System.out.println("You are all right");
        }
    }
}
