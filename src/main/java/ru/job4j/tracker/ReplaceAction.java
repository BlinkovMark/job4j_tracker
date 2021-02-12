package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id to edit: ");
        String newItem = input.askStr("Enter new name of item: ");
        Item name = new Item(newItem);
        if (tracker.replace(id, name)) {
            System.out.println("Completed");
        } else {
            System.out.println("Error");
        }
        System.out.println();
        return true;
    }
}
