package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("== All items ==");
        List<Item> showAll = tracker.findAll();
        for (Item item : showAll) {
            out.println(item);
        }
        out.println(System.lineSeparator());
        return true;
    }
}
