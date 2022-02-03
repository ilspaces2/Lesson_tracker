package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void whenSortItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("C", 2),
                new Item("A", 6),
                new Item("D", 5),
                new Item("B", 7)
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("A", 6),
                new Item("B", 7),
                new Item("C", 2),
                new Item("D", 5)
        );
        assertTrue(items.equals(expected));
    }

    @Test
    public void whenSortItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("C", 2),
                new Item("A", 6),
                new Item("D", 5),
                new Item("B", 7)
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("D", 5),
                new Item("C", 2),
                new Item("B", 7),
                new Item("A", 6)
        );
        assertTrue(items.equals(expected));
    }

}