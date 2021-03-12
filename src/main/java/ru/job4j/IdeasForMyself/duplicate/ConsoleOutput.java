package ru.job4j.IdeasForMyself.duplicate;

public class ConsoleOutput implements Output {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}