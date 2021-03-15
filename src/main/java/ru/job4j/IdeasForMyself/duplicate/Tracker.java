package ru.job4j.IdeasForMyself.duplicate;

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
        Item[] rsl = new Item[items.length];
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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
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
        items[index] = item;
        rsl = true;
        }
        return rsl;
}

    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        boolean valid = index != -1;
        if (valid) {
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
            rsl = true;
        }
        return rsl;
    }
}