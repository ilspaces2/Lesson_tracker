package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftArray = left.split(". ");
        int leftParse = Integer.parseInt(leftArray[0]);
        String[] rightArray = right.split(". ");
        int rightParse = Integer.parseInt(rightArray[0]);
        return Integer.compare(leftParse, rightParse);
    }
}