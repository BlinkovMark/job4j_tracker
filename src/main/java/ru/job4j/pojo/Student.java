package ru.job4j.pojo;

public class Student {
    private String FIO;
    private String group;
    private int startDate;

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public String getFIO() {
        return FIO;
    }

    public String getGroup() {
        return group;
    }

    public int getStartDate() {
        return startDate;
    }
}
