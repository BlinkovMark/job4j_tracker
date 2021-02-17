package ru.job4j.tracker;

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
        Item[] showAll = tracker.findAll();
        for (int i = 0; i < showAll.length; i++) {
            out.println(showAll[i]);
        }
        out.println(System.lineSeparator());
        return true;
    }
}
