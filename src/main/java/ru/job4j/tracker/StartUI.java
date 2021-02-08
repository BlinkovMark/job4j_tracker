package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askInt("Select: "));
                if (select == 0) {
                    System.out.println("=== Create a new Item ====");
                    String name = input.askStr("Enter name: ");
                    Item item = new Item(name);
                    tracker.add(item);
                    System.out.println();
                } else if (select == 1) {
                    System.out.println("=== Show all items ===");
                    Item[] showAll = tracker.findAll();
                    for (int i = 0; i < showAll.length; i++) {
                        System.out.println(showAll[i]);
                        System.out.println();
                    }
                } else if (select == 2) {
                    System.out.println("=== Edit item ===");
                    String id = input.askStr("Enter id to edit: ");
                    String newItem = input.askStr("Enter new name of item: ");
                    Item name = new Item(newItem);
                    if (tracker.replace(Integer.parseInt(id), name)) {
                        System.out.println("Completed");
                    } else {
                        System.out.println("Error");
                    }
                    System.out.println();
                } else if (select == 3) {
                    System.out.println("=== Delete item ===");
                    String id = input.askStr("Enter id to delete: ");
                    if (tracker.delete(Integer.parseInt(id))) {
                        System.out.println("Completed");
                    } else {
                        System.out.println("Error");
                    }
                    System.out.println();
                } else if (select == 4) {
                    System.out.println("=== Find item by Id ===");
                    String id = input.askStr("Enter id: ");
                    Item showById = tracker.findById(Integer.parseInt(id));
                    if (showById != null) {
                        System.out.println(showById);
                    } else {
                        System.out.println("Заявка с таким id не найдена");
                    }
                    System.out.println();
                } else if (select == 5) {
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