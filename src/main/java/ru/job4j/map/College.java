package ru.job4j.map;

import java.util.Map;
import java.util.Set;

/**
 * Класс получает лист студентов и преобразует в map.
 * С помощью методов класса осуществляем поиск.
 * Поскольку Map не является наследником интерфейса Collection,
 * то в Map не определен метод stream() - соответственно мы не можем получить поток значений напрямую.
 * Однако у Map есть метод keySet(), который возвращает набор всех ключей в виде коллекции типа Set.
 */

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    /**
     * С помощью keySet()(который дает нам stream(), ключи в данном случае аккаунты)
     * фильтруем нужный нам аккаунт и возвращаем первый найденный,
     * если не находим то возвращаем null
     *
     * @param account аккаунт который надо найти
     * @return возвращаем аккаунт или null
     */
    public Student findByAccount(String account) {
        return students.keySet().stream()
                .filter(e -> e.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }

    /**
     * Находим студента по аккаунту. Студент содержит сет предметов.
     * Фильтруем предметы по нужному имени,находим первый попавшийся
     * и возвращаем.
     *
     * @param account аккаунт для поиска студента
     * @param name    имя предмета для поиска
     * @return возвращаем предмет или null
     */
    public Subject findBySubjectName(String account, String name) {
        Student a = findByAccount(account);
        if (a != null) {
            return students.get(a).stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        College college = new College(students);
        Student student = college.findByAccount("000001");
        System.out.println("Найденный студент: " + student);
        Subject english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по найденному предмету: " + english.getScore());
    }
}