package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("War and Peace", 1255);
        Book second = new Book("Fault In Our Stars", 3155);
        Book third = new Book("The Maze Runner", 798);
        Book fourth = new Book("Clean Code", 0);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        for (int i = 0; i < books.length; i++) {
            Book rsl = books[i];
            System.out.println(rsl.getName() + " - " + rsl.getPages());
        }
        System.out.println();
        System.out.println("Switch 0 and 3");
        System.out.println();
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            Book rsl = books[i];
            System.out.println(rsl.getName() + " - " + rsl.getPages());
        }
        System.out.println();
        System.out.println("Shown only Clean Code");
        for (int i = 0; i < books.length; i++) {
            Book rsl = books[i];
            if (rsl.getName().equals("Clean Code")) {
                System.out.println(rsl.getName() + " - " + rsl.getPages());
            }
        }
    }
}
