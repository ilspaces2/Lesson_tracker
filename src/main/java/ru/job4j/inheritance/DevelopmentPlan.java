package ru.job4j.inheritance;

public class DevelopmentPlan {
    private int periodOfExecution;
    private TechnicalTask technicalTask;

    public DevelopmentPlan(int periodOfExecution, TechnicalTask technicalTask) {
        this.periodOfExecution = periodOfExecution;
        this.technicalTask = technicalTask;
    }

    public int getPeriodOfExecution() {
        return periodOfExecution;
    }

    public TechnicalTask getTechnicalTask() {
        return technicalTask;
    }
}
