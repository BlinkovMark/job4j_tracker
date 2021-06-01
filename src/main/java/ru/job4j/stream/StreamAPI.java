package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 4, -2, 7, -5, 10, 3, -3, -1, 15));
        List<Integer> rsl = list.stream()
                .filter(a -> a > 0)
                .collect(Collectors.toList());
        System.out.println(rsl);
    }
}
