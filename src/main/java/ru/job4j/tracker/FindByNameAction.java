package ru.job4j.tracker;

import java.util.List;

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
        List<Item> showByName = tracker.findByName(key);
        if (showByName.size() > 0) {
            for (Item item : showByName) {
                out.println(item);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        out.println(System.lineSeparator());
        return true;
    }
}
