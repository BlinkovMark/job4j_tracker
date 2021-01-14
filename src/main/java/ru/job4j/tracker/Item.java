package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public void Item(int id) {
        this.id = id;
    }

    public void Item(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}