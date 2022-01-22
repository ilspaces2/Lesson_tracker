package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroup("P-102");
        student.setEntryDate(LocalDate.of(2000, 9, 1));
        System.out.println("Студент " + student.getFullName() + " учится в группе " + student.getGroup()
                + " и поступил " + student.getEntryDate() + ".");
    }
}
