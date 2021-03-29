package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) throws Error404Exception {
            ArrayList<Person> result = new ArrayList<>();
            for (Person rsl : persons) {
                if (rsl.getName().contains(key) ||
                        rsl.getSurname().contains(key) ||
                        rsl.getAddress().contains(key) ||
                        rsl.getPhone().contains(key)) {
                    result.add(rsl);
                } else {
                    throw new Error404Exception("Error 404");
                }
            }
        return result;
    }
}