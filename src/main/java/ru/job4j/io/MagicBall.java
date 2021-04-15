package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        System.out.println();
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String rsl;
        Scanner input = new Scanner(System.in);
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        System.out.println(question);
        if (answer == 0) {
            rsl = "Да";
        } else if (answer == 1) {
            rsl = "Нет";
        } else {
            rsl = "Может быть";
        }
        System.out.println(rsl);
    }
}
