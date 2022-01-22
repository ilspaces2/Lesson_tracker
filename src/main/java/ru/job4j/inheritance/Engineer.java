package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String engineerIt = "Engineers are called inventors";

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public String getEngineerIt() {
        return engineerIt;
    }

    public DevelopmentPlan creating(int periodOfExecution, TechnicalTask technicalTask) {
        return new DevelopmentPlan(periodOfExecution, technicalTask);
    }
}
