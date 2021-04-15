package ru.job4j.profession;

public class Builder extends Engineer {
    private int brick;

    public Builder(String plan) {
        super(plan);
    }

    public Builder(int brick) {
        this.brick = brick;
    }

    public String build(int brick) {
        return null;
    }

    public String getName() {
        return null;
    }

    public String getSurname() {
        return null;
    }

    public int getMoney() {
        return 0;
    }
}