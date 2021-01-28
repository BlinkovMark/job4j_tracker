package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }


    public Item[] findByName(String key) {
        int val = 0;
        Item[] rsl =  new Item[items.length];
        for (int i = 0; i < size; i++) {
            Item name = items[i];
            if (key.equals(name.getName())) {
                rsl[val] = name;
                val++;
            }
        }
        rsl = Arrays.copyOf(rsl, val);
        return rsl;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}