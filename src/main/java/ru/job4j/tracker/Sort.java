package ru.job4j.tracker; //again

import java.util.Comparator;

public class Sort implements Comparator<Item> {
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
