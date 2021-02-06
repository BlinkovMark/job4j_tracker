package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
    }

    @Override
    public int passengers() {
        return 0;
    }

    @Override
    public int fuel(int price) {
        return 0;
    }
}
