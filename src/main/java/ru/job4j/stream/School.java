package ru.job4j.stream;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;
import java.util.function.Predicate;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> map(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(Student::getSurname, Student::getScore));
    }

    public Map<String, Integer> collectMap(List<Student> students, Predicate<Student> predict) {
        return map(collect(students, predict));
    }
}
