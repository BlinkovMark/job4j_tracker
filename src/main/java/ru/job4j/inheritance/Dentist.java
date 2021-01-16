package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int tooth;

    public Dentist(int tooth) {
        this.tooth = tooth;
    }

    public String pull(int tooth) {
        return null;
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
}
