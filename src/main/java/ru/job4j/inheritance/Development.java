package ru.job4j.inheritance;

public class Development {
    public static void main(String[] args) {
        TechnicalTask technicalTask = new TechnicalTask("Prog", "Write Web app", 1);
        Programmer proger = new Programmer("Lyi", "Chips", "Proger", "01.01.1984", "Developer", "Java");
        DevelopmentPlan developmentPlan = proger.creating(3, technicalTask);
        proger.coding(developmentPlan);
        System.out.println("------");
        TechnicalTask technicalTaskTwo = new TechnicalTask("Build", "Build wood house", 2);
        Builder builder = new Builder("Ji", "Ti", "Builder", "01.01.1974", "Main Builder", "Woodworker");
        DevelopmentPlan developmentPlanTwo = builder.creating(12, technicalTaskTwo);
        builder.building(developmentPlanTwo);
    }
}
