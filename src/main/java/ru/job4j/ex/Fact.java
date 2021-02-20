 package ru.job4j.ex;

 import java.util.Scanner;

 public class Fact {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число ");
        String num = input.nextLine();
        System.out.println("Факториал числа " + num + " равен: " + calc(Integer.parseInt(num)));
    }

    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be more than 0");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
