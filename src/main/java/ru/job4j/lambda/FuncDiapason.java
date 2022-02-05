package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class FuncDiapason {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        Supplier<List<Double>> sup = ArrayList::new;
        List<Double> list = sup.get();
        Consumer<Double> cons = list::add;
        for (double i = start; i < end; i++) {
            cons.accept(func.apply(i));
        }
        return list;
    }
}
