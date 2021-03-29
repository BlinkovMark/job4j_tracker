package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() throws Error404Exception {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Mark", "Blinkov", "55921184", "Tallinn"));
        ArrayList<Person> persons = phones.find("Mark");
        assertThat(persons.get(0).getSurname(), is("Blinkov"));
    }


    @Test(expected = Error404Exception.class)
    public void whenNotFound() throws Error404Exception {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Mark", "Blinkov", "55921184", "Tallinn"));
        phones.find("0");
    }
}