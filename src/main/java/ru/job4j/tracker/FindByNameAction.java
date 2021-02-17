package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("== Find items by name ==");
        String key = input.askStr("Enter name: ");
        Item[] showByName = tracker.findByName(key);
        if (showByName.length > 0) {
            for (int i = 0; i < showByName.length; i++) {
                out.println(showByName[i]);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        out.println(System.lineSeparator());
        return true;
    }
}
