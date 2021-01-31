package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        Item user = new Item(1, "Mark", LocalDateTime.now());
        tracker.add(item);
        System.out.println("toString" + user);
        System.out.println();
        System.out.println(tracker.findById(item.getId()));
        System.out.println();

        System.out.println("Текущие дата и время до форматирования: " + item.getDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String dateFormat = item.getDate().format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + dateFormat);

    }
}