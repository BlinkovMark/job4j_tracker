//package ru.job4j.IdeasForMyself;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class Blinkov {
//    public static String findNPS(String[] family, String find) {
//        String rsl = null;
//        for (int i = 0; i < family.length; i++) {
//            if (find.equals(family[i])) {
//                rsl = family[i];
//            }
//        }
//        return rsl;
//    }
//
//    public String play(String stats) {
//        return "playing " + stats;
//    }
//
//    public String getNik(String nik) {
//        return nik;
//    }
//
//    public static void main(String[] args) {
//        Blinkov family = new Blinkov();
//        Scanner input = new Scanner(System.in);
//        System.out.println("Введите имя пользователя");
//        String find = input.nextLine();
//        String name = family.getNik(find);
//        int randomGame = new Random().nextInt(3);
//       switch (randomGame) {
//            case 0 -> System.out.println("Rocket League");
//            case 1 -> System.out.println("Minecraft");
//            case 2 -> System.out.println("Need For Speed");
//        };
//                String now = family.play(randomGame);
//                findNPS(new String[]{"Nik", "Regina", "Inna", "Mark"}, find);
//                System.out.println(name);
//                System.out.println(now);
//            }
//        }
