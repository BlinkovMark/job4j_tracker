package ru.job4j.pojo;

public class Student {
    private String fio;
    private String group;
    private int startDate;

    public void setFIO(String fio) {
        this.fio = fio;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public String getFio() {
        return fio;
    }

    public String getGroup() {
        return group;
    }

    public int getStartDate() {
        return startDate;
    }
}
