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
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item name = items[i];
            if (name != null) {
                itemsWithoutNull[size] = name;
                size++;
            }
        }
            itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
            return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] rsl =  new Item[items.length];
        for (int i = 0; i < size; i++) {
            Item name = items[i];
            if (key.equals(name.getName())) {
                rsl[size] = name;
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
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