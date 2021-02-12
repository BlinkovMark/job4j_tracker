package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String key = input.askStr("Enter name: ");
        Item[] showByName = tracker.findByName(key);
        if (showByName.length > 0) {
            for (int i = 0; i < showByName.length; i++) {
                System.out.println(showByName[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        System.out.println();
        return true;
    }
}
