package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = 0;
        for (int i = 0; i < value.length; i++) {
                if (key.equals(value[i])) {
                    rsl = i;
                }
        }
        if (!key.equals(value[rsl])) {
            throw new ElementNotFoundException("Error 404");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            System.out.println(indexOf(new String[]{"nik", "regina", "inna", "mark", "dan"},
                    "mark"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}