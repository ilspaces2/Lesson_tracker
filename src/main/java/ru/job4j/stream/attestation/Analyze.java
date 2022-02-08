package ru.job4j.stream.attestation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс Analyze получает статистику по аттестатам.
 */
public class Analyze {
    /**
     * Метод averageScore вычисляет общий средний балл.
     *
     * @param stream получаем поток учеников
     * @return возвращаем средний балл
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
     *
     * @param stream получаем поток учеников
     * @return возвращает список объектов Tuple(имя, средний бал)
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
     *
     * @param stream получаем поток учеников
     * @return возвращает список объектов Tuple(название предмета, средний бал)
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(key -> new Tuple(key.getKey(), key.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод bestStudent - возвращает лучшего ученика. Лучшим считается ученик с наибольшим баллом по всем предметам.
     *
     * @param stream получаем поток учеников
     * @return возвращает объект Tuple(имя, максимальный бал)
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("Not found", 0));
    }

    /**
     * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     *
     * @param stream получаем поток учеников
     * @return возвращает объект Tuple(название предмета, сумма баллов каждого ученика по этому предмету)
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(key -> new Tuple(key.getKey(), key.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("Not found", 0));
    }
}