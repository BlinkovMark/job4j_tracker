package ru.job4j.IdeasForMyself.duplicate;

import java.time.LocalDateTime;

public class Item {
    private int id;
    private String name;
    private LocalDateTime date = LocalDateTime.now();

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public Item() {
    }
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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
}