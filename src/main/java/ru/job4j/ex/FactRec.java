package ru.job4j.ex;

import java.util.ArrayList;

public class FactRec {

    public static int calc(int n) {
        if (n == 1) {
            return 1;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int rsl = calc(3);
        System.out.println(rsl);
    }
}