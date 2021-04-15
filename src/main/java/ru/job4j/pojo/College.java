package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFIO("Mark Blinkov Maksimovich");
        student.setGroup("11A");
        student.setStartDate(2020);
        System.out.println(student.getFio() + " : "
                + student.getGroup() + " : "
                + student.getStartDate());
    }
}
