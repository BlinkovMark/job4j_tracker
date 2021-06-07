package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapUsage {
    public List<Integer> toMap(List<List<Integer>> list) {
        return list.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
