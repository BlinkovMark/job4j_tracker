package ru.job4j.IdeasForMyself.duplicate;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}