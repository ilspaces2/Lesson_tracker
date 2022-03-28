package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenAddItemsAndFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> expected = new ArrayList<>();
        Item item = new Item("item");
        tracker.add(item);
        expected.add(item);
        item = new Item("item2");
        tracker.add(item);
        expected.add(item);
        item = new Item("item3");
        tracker.add(item);
        expected.add(item);
        item = new Item("item4");
        tracker.add(item);
        expected.add(item);
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenAddItemAndReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item newItem = new Item("newItem");
        tracker.replace(item.getId(), newItem);
        assertThat(tracker.findById(item.getId()), is(newItem));
    }

    @Test
    public void whenAddItemAndDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenAddItemsAndFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> expected = new ArrayList<>();
        Item item = new Item("item");
        tracker.add(item);
        item = new Item("item2");
        tracker.add(item);
        expected.add(item);
        item = new Item("item2");
        tracker.add(item);
        expected.add(item);
        assertThat(tracker.findByName("item2"), is(expected));
    }

}