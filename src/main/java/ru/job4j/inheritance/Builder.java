package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String specialization;

    public Builder(String name, String surname, String education, String birthday, String specialization) {
        super(name, surname, education, birthday);
        this.specialization = specialization;
    }

    public void building(DevelopmentPlan developmentPlan) {
        setSpecialization(specialization);
        System.out.println("Hi, i am " + getName() + ", i am " + getSpecialization());
        System.out.println("I " + developmentPlan.getTechnicalTask().getDescription() + " for "
                + developmentPlan.getPeriodOfExecution() + " month");
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
