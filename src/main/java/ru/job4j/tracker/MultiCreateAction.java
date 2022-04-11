package ru.job4j.tracker;

import java.util.Random;

public class MultiCreateAction implements UserAction {
    private final Output out;
    private final int capacity;

    public MultiCreateAction(Output out, int capacity) {
        this.out = out;
        this.capacity = capacity;
    }

    @Override
    public String name() {
        return "Multi add new Item`s";
    }

    @Override
    public boolean execute(Input input, Store tracker) {

        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            String name = String.valueOf((char) random.nextInt(65000))
                    .repeat(random.nextInt(50));
            Item item = new Item(name);
            tracker.add(item);
        }
        out.println("=======Created=======");
        return true;
    }
}
