package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println();
    }

    public static void showItem(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] showAll = tracker.findAll();
        for (int i = 0; i < showAll.length; i++) {
            System.out.println(showAll[i]);
        }
        System.out.println();
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Enter id to edit: ");
        String newItem = input.askStr("Enter new name of item: ");
        Item name = new Item(newItem);
        if (tracker.replace(id, name)) {
            System.out.println("Completed");
        } else {
            System.out.println("Error");
        }
        System.out.println();
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Completed");
        } else {
            System.out.println("Error");
        }
        System.out.println();
    }

    public static void findByIdItem(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        int id = input.askInt("Enter id: ");
        Item showById = tracker.findById(id);
        if (showById != null) {
            System.out.println(showById);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        System.out.println();
    }

    public static void findByNameItem(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
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
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
                if (select == 0) {
                    StartUI.createItem(input, tracker);
                } else if (select == 1) {
                    StartUI.showItem(tracker);
                } else if (select == 2) {
                    StartUI.replaceItem(input, tracker);
                } else if (select == 3) {
                   StartUI.deleteItem(input, tracker);
                } else if (select == 4) {
                    StartUI.findByIdItem(input, tracker);
                } else if (select == 5) {
                    StartUI.findByNameItem(input, tracker);
                } else if (select == 6) {
                    System.out.println("Bye");
                    run = false;
                }
            }
        }


    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}