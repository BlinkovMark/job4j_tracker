package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            if (matches >= 1 && matches <= 3) {
                count -= matches;
            }
            else {
                int answer = new Random().nextInt(3);
                switch (answer) {
                    case 0 -> System.out.println("Жулик не воруй;)");
                    case 1 -> System.out.println("Упс!");
                    case 2 -> { System.out.println("Обработка запроса...");
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Ошибка!");
                    }
                }
                turn = !turn;
            }
            System.out.println("Осталось спичек: " + count);
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}

