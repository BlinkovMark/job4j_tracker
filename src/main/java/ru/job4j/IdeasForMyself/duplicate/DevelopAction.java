package ru.job4j.IdeasForMyself.duplicate;

public class DevelopAction implements UserAction{
    private final Output out;

    public DevelopAction(Output out) {this.out = out;}

    @Override
    public String name() {
        return "Switch to night mode";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("= Done(example) =");
        out.println(System.lineSeparator());
        return true;
    }
}

