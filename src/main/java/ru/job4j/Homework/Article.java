package ru.job4j.Homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = false;
        String[] originText = origin.split("[ ,.!:;]");
        String[] lineText = line.split(" ");
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList(originText));
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList(lineText));
        if (listOne.containsAll(listTwo)) {
            rsl = true;
        }
        return rsl;
    }
}