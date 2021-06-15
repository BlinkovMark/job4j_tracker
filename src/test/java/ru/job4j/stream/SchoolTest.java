package ru.job4j.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = a -> a.getScore() >= 70 && a.getScore() <= 100;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = List.of(
                new Student(70, "Surname7"),
                new Student(90, "Surname9"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(80, "Surname8")
        );
        School sc = new School();
        Predicate<Student> pr = a -> a.getScore() >= 50 && a.getScore() < 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected =  List.of(
                new Student(50, "Surname5"),
                new Student(60, "Surname6"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassV() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(60, "Surname6"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = a -> a.getScore() > 0 && a.getScore() < 50;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected =  List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenMap() {
        List<Student> students = List.of(
                new Student("Surname2", 64),
                new Student("Surname1", 13),
                new Student("Surname3", 53),
                new Student("Surname1", 13),
                new Student("Surname3", 53),
                new Student("Surname2", 35),
                new Student("Surname4", 89)

        );
        School sc = new School();
        Map<String, Student> rsl = sc.map(students);
        Map<String, Student> expected = Map.of(
                "Surname1", new Student("Surname1", 13),
                "Surname2", new Student("Surname2", 64),
                "Surname3", new Student("Surname3", 53),
                "Surname4", new Student("Surname4", 89));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenMapClassA() {
        List<Student> students = List.of(
                new Student("Surname2", 86),
                new Student("Surname1", 70),
                new Student("Surname3", 79),
                new Student("Surname1", 70),
                new Student("Surname2", 86),
                new Student("Surname5", 59),
                new Student("Surname4", 98)

        );
        School sc = new School();
        Predicate<Student> pr = a -> a.getScore() >= 70 && a.getScore() <= 100;
        Map<String, Student> rsl = sc.collectMap(students, pr);
        Map<String, Student> expected = Map.of(
                "Surname4", new Student("Surname4", 98),
                "Surname3", new Student("Surname3", 79),
                "Surname2", new Student("Surname2", 86),
                "Surname1", new Student("Surname1", 70));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenMapClassB() {
        List<Student> students = List.of(
                new Student("Surname2", 64),
                new Student("Surname1", 53),
                new Student("Surname3", 67),
                new Student("Surname1", 53),
                new Student("Surname5", 35),
                new Student("Surname3", 67),
                new Student("Surname4", 58)
        );
        School sc = new School();
        Predicate<Student> pr = a -> a.getScore() >= 50 && a.getScore() < 70;
        Map<String, Student> rsl = sc.collectMap(students, pr);
        Map<String, Student> expected = Map.of(
                "Surname3", new Student("Surname3", 67),
                "Surname2", new Student("Surname2", 64),
                "Surname4", new Student("Surname4", 58),
                "Surname1", new Student("Surname1", 53));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenMapClassV() {
        List<Student> students = List.of(
                new Student("Surname2", 34),
                new Student("Surname3", 12),
                new Student("Surname1", 76),
                new Student("Surname3", 12),
                new Student("Surname2", 34),
                new Student("Surname4", 41),
                new Student("Surname5", 24)

        );
        School sc = new School();
        Predicate<Student> pr = a -> a.getScore() > 0 && a.getScore() < 50;
        Map<String, Student> rsl = sc.collectMap(students, pr);
        Map<String, Student> expected = Map.of(
                "Surname4", new Student("Surname4", 41),
                "Surname2", new Student("Surname2", 34),
                "Surname5", new Student("Surname5", 24),
                "Surname3", new Student("Surname3", 12));
        assertThat(rsl, is(expected));
    }
}