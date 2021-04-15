package ru.job4j.profession;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private int birthday;
    private int money;

    public Profession() {
    }

    public Profession(String name, String surname, String edu) {
        this.name = name;
        this.surname = surname;
        this.education = edu;
    }

    public Profession(int birth, int money) {
        this.birthday = birth;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEdu() {
        return education;
    }

    public int getBirth() {
        return birthday;
    }

    public int getMoney() {
        return money;
    }
}
