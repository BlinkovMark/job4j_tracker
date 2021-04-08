package ru.job4j.collection;

import java.util.Comparator;

public class ByNameSortReverse implements Comparator<Job> {

    public int compare(Job first, Job second) {
        return second.getName().compareTo(first.getName());
    }
}
