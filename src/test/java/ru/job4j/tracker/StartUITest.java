package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        Input input = new StubInput(new String[]{"0", "Create item", "1"});
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new CreateAction(out), new ExitAction(out));
        new StartUI(out).init(input, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Create item"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new ConsoleOutput();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Replace item");
        memTracker.add(item);
        String replacedName = "New item name";
        Input input = new StubInput(new String[]{"0", String.valueOf(item.getId()), replacedName, "1"});
        List<UserAction> actions = Arrays.asList(new EditAction(out), new ExitAction(out));
        new StartUI(out).init(input, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Delete item");
        memTracker.add(item);
        Input input = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = Arrays.asList(new DeleteAction(out), new ExitAction(out));
        new StartUI(out).init(input, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
                        + "=== Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Edit test"));
        String replaceName = "New name";
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), replaceName, "1"});
        List<UserAction> actions = Arrays.asList(new EditAction(out), new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit ===" + ln
        ));
    }

    @Test
    public void whenFindAllItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("Find all test one"));
        Item two = memTracker.add(new Item("Find all test two"));
        Input in = new StubInput(new String[]{"0", "1"});
        List<UserAction> actions = Arrays.asList(new ShowAllAction(out), new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + two + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit ===" + ln
        ));
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("Find by name test"));
        Input in = new StubInput(new String[]{"0", one.getName(), "1"});
        List<UserAction> actions = Arrays.asList(new FindByNameAction(out), new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit ===" + ln
        ));
    }

    @Test
    public void whenFindByIdTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("Find by id test"));
        Input in = new StubInput(new String[]{"0", String.valueOf(one.getId()), "1"});
        List<UserAction> actions = Arrays.asList(new FindByIdAction(out), new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit ===" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"3", "0"});
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. " + (actions.size() - 1) + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit ===" + ln
        ));

    }

    @Test
    public void whenReplaceItemWithMock() {
        Output out = new StubOutput();
        EditAction editAction = new EditAction(out);
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Replace item");
        memTracker.add(item);
        String replacedName = "New item name";
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        editAction.execute(input, memTracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ===" + ln + "Заявка изменена успешно." + ln));
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItemWithMock() {
        Output out = new StubOutput();
        DeleteAction deleteAction = new DeleteAction(out);
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Delete item");
        memTracker.add(item);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        deleteAction.execute(input, memTracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Заявка удалена успешно." + ln));
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindByIdIWithMock() {
        Output out = new StubOutput();
        FindByIdAction findByIdAction = new FindByIdAction(out);
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Find by id");
        memTracker.add(item);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        findByIdAction.execute(input, memTracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(),
                is("=== Find item by id ===" + ln + memTracker.findById(item.getId()) + ln));
    }

    @Test
    public void whenFindByNameWithMock() {
        Output out = new StubOutput();
        FindByNameAction findByNameAction = new FindByNameAction(out);
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Find by name");
        memTracker.add(item);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        findByNameAction.execute(input, memTracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(),
                is("=== Find items by name ===" + ln + memTracker.findById(item.getId()) + ln));
    }
}