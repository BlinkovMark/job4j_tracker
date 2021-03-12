package ru.job4j.IdeasForMyself.duplicate;

public class BackAction implements UserAction {
    private final Output out;

    public BackAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Back";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("Back");
        out.println(System.lineSeparator());
        return false;
    }
}
