package ru.job4j.tracker;

public class DeleteAllAction implements UserAction {

    @Override
    public String name() {
        return "Delete all item`s";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return tracker.deleteAll();
    }
}
