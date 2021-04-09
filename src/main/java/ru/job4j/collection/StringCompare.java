package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] lt = left.toCharArray();
        char[] rt = right.toCharArray();
        for (int i = 0; i <= lt.length - 1; i++) {
            if (lt[i] != rt[i]) {
                return Character.compare(lt[i], rt[i]);
            }
        }
        if (left.length() != right.length()) {
            return Integer.compare(left.length(), right.length());
        }
       return 0;
    }
}