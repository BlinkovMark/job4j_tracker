package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item implements Comparable<Item> {
    private int id;
    private String name;
    private LocalDateTime date = LocalDateTime.now();
    private int priority;

    public Item() {}
    public Item(int id) {
        this.id = id;
    }
    public Item(String name) {
        this.name = name;
    }
    public Item(LocalDateTime date) {
        this.date = date;
    }

    public Item(int id, String name, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.date = date;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Item another) {
        return Integer.compare(priority, another.priority);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}