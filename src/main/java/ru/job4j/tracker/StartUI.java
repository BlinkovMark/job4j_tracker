package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        System.out.println(tracker.findById(item.getId()));

        System.out.println("Текущие дата и время до форматирования: " + item.getCreated());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdFormat = item.getCreated().format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + createdFormat);

    }
}