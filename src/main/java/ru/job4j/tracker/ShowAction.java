package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] showAll = tracker.findAll();
        for (int i = 0; i < showAll.length; i++) {
            System.out.println(showAll[i]);
        }
        System.out.println();
        return true;
    }
}
