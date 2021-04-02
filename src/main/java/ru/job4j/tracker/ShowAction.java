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
        for (int i = 0; i < showAll.size(); i++) {
            out.println(showAll.get(i));
        }
        out.println(System.lineSeparator());
        return true;
    }
}
