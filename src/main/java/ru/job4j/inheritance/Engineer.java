package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String engineerIt;

    public Engineer(String name, String surname, String education, String birthday, String engineerIt) {
        super(name, surname, education, birthday);
        this.engineerIt = engineerIt;
    }

    public String getEngineerIt() {
        return engineerIt;
    }

    public DevelopmentPlan creating(int periodOfExecution, TechnicalTask technicalTask) {
        return new DevelopmentPlan(periodOfExecution, technicalTask);
    }
}
