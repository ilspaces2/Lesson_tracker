package ru.job4j.tracker;

public class ShowAllActionReactive implements UserAction {
    private final Output out;

    public ShowAllActionReactive(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items reactive";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Show all items reactive ===");
        tracker.findAll(out::println);
        return true;
    }
}
