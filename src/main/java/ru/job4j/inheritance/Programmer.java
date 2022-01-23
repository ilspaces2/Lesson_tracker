package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String programmingLanguage;

    public Programmer(String name, String surname, String education, String birthday, String engineerIt, String programmingLanguage) {
        super(name, surname, education, birthday, engineerIt);
        this.programmingLanguage = programmingLanguage;
    }

    public void coding(DevelopmentPlan developmentPlan) {
        System.out.println("ID : " + developmentPlan.getTechnicalTask().getId());
        System.out.println("Name : " + developmentPlan.getTechnicalTask().getName());
        System.out.println("Description: " + developmentPlan.getTechnicalTask().getDescription());
        System.out.println("Period: " + developmentPlan.getPeriodOfExecution() + " month");
        setProgrammingLanguage(programmingLanguage);
        System.out.println("Select language: " + getProgrammingLanguage());
        System.out.println("Start coding");

    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
}
