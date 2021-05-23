package ru.job4j.Homework;

import java.util.Arrays;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] originText = origin.replaceAll("\\p{P}", "").split(" ");
        String[] lineText = line.replaceAll("\\p{P}", "").split(" ");
        HashSet<String> listOne = new HashSet<>(Arrays.asList(originText));
        for (String listTwo : lineText) {
            if (!listOne.contains(listTwo)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}