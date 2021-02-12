package ru.job4j.tracker;

public class ShutdownAction implements UserAction {
    private final Output out;

    public ShutdownAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Shutdown";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("Bye");
        return false;
    }
}