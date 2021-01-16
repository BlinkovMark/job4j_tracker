package ru.job4j.profession;// again

public class Engineer extends Profession {
    private String plan;

    public Engineer(String name, String surname, String edu) {
        super(name, surname, edu);
    }
    public Engineer(int birth, int money) {
        super(birth, money);
    }

    public Engineer() {
    }
    public Engineer(String plan) {
        this.plan = plan;
    }


    public String draw(String plan) {
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
