package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Completed");
        } else {
            System.out.println("Error");
        }
        System.out.println();
        return true;
    }
}