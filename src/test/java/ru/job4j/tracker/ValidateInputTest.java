package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenPrintErrMsg() {
        Output out = new StubOutput();
        Input in = new ValidateInput(out, new StubInput(new String[]{"ExitErr", "0"}));
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Please enter validate data again." + ln
                        + "=== Exit ===" + ln
        ));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidMultiInput() {
        Output out = new StubOutput();
        String[] stubInput = {"2", "3", "1", "0"};
        Input in = new StubInput(stubInput);
        ValidateInput input = new ValidateInput(out, in);
        int[] selected = new int[stubInput.length];
        for (int i = 0; i < selected.length; i++) {
            selected[i] = input.askInt("Enter menu:");
        }
        int[] expected = {2, 3, 1, 0};
        assertArrayEquals(expected, selected);
    }

    @Test
    public void whenValidNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-2));
    }

}