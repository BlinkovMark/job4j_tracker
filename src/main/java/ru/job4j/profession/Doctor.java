package ru.job4j.profession;// again

public class Doctor extends Profession {
    private int ward;

    public Doctor(String name, String surname, String edu) {
        super(name, surname, edu);
    }
    public Doctor(int birth, int money) {
        super(birth, money);
    }

    public Doctor() {
    }
    public Doctor(int ward) {
        this.ward = ward;
    }

    public int run(int ward) {
        return 0;
    }
    public String heal(Patient patient) {
        return null;
    }
    public String getName() {
        return null;
    }
    public String getSurname() {
        return null;
    }
    public int getMoney() {
        return 0;
    }
    public String getEdu() {
        return null;
    }
}

