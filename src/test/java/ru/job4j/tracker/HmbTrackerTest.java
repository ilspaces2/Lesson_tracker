package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class HmbTrackerTest {

    @Test
    public void whenAddItem() {
        HmbTracker tracker = new HmbTracker();
        tracker.add(new Item("item", "add new item"));
        List<Item> items = tracker.findAll();
        assertThat(items.get(0).getDescription(), is("add new item"));
    }

    @Test
    public void whenDeleteAll() {
        HmbTracker tracker = new HmbTracker();
        tracker.add(new Item("item one", "add new item one"));
        tracker.add(new Item("item two", "add new item two"));
        assertTrue(tracker.deleteAll());
        assertTrue(tracker.findAll().isEmpty());
    }

    @Test
    public void whenReplace() {
        HmbTracker tracker = new HmbTracker();
        Item itemOne = new Item("item one", "add new item one");
        Item itemTwo = new Item("item two", "add new item two");
        tracker.add(itemOne);
        assertTrue(tracker.replace(itemOne.getId(), itemTwo));
        assertThat(tracker.findAll().get(0).getName(), is(itemTwo.getName()));
    }

    @Test
    public void whenDeleteById() {
        HmbTracker tracker = new HmbTracker();
        Item itemOne = new Item("item one", "add new item one");
        Item itemTwo = new Item("item two", "add new item two");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        assertTrue(tracker.delete(itemOne.getId()));
        assertThat(tracker.findAll().get(0).getName(), is(itemTwo.getName()));
    }

    @Test
    public void whenFindByName() {
        HmbTracker tracker = new HmbTracker();
        Item itemOne = new Item("item one", "add new item one");
        Item itemTwo = new Item("item two", "add new item two");
        Item itemThree = new Item("item two", "add new item three");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        List<Item> items = tracker.findByName(itemTwo.getName());
        assertThat(items.get(0).getName(), is(itemTwo.getName()));
        assertThat(items.get(1).getName(), is(itemTwo.getName()));
    }

    @Test
    public void whenFindById() {
        HmbTracker tracker = new HmbTracker();
        Item itemOne = new Item("item one", "add new item one");
        Item itemTwo = new Item("item two", "add new item two");
        Item itemThree = new Item("item two", "add new item three");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        Item itemDB = tracker.findById(itemThree.getId());
        assertThat(itemDB.getDescription(), is(itemThree.getDescription()));
    }
}
