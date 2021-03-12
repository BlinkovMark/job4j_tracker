package ru.job4j.IdeasForMyself.duplicate;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("== Edit item ==");
        int id = input.askInt("Enter id to edit: ");
        String newItem = input.askStr("Enter new name of item: ");
        Item name = new Item(newItem);
        if (tracker.replace(id, name)) {
            out.println("Completed");
        } else {
            out.println("Error");
        }
        out.println(System.lineSeparator());
        return true;
    }
}
