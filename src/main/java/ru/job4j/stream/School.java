package ru.job4j.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    public Map<String, Student> map(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getSurname, a -> a, (a, b) -> a));
    }

    public Map<String, Student> collectMap(List<Student> students, Predicate<Student> predict) {
        return map(collect(students, predict));
    }
}
