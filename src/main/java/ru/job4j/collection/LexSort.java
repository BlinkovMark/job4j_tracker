package ru.job4j.collection;


import java.util.Comparator;
public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] lt = left.split(". " );
        String[] rt = right.split(". ");
        int l = Integer.parseInt(lt[0]);
        int r = Integer.parseInt(rt[0]);
        return Integer.compare(l, r);
    }
}