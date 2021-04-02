package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>(100);
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }


    public Item[] findByName(String key) {
        int val = 0;
        Item[] rsl = new Item[items.size()];
        for (int i = 0; i < size; i++) {
            Item name = items.get(i);
            if (key.equals(name.getName())) {
                rsl[val] = name;
                val++;
            }
        }
        rsl = Arrays.copyOf(rsl, val);
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        boolean valid = index != -1;
        if (valid) {
        item.setId(id);
        items.set(index, item);
        rsl = true;
        }
        return rsl;
}

    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        boolean valid = index != -1;
        if (valid) {
            items.remove(index);
            rsl = true;
        }
        return rsl;
    }
}