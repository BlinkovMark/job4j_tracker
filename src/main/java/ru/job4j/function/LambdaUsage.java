package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] strings = {
            "image 1","image 3", "image 2" };
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + right + " : " + left);
            return right.compareTo(left);
        };
        Arrays.sort(strings, comparator);
        System.out.println(Arrays.toString(strings));
    }
}
