package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Mark", "Blinkov", "55921184", "Tallinn"));
        var persons = phones.find("Mark");
        assertThat(persons.get(0).getSurname(), is("Blinkov"));
    }

    @Test
    public void whenNotFound() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Mark", "Blinkov", "55921184", "Tallinn"));
        var persons = phones.find("F");
        assertThat(persons.toArray().length, is(0));
    }

        @Test
        public void whenFindByName2() {
            PhoneDictionary phones = new PhoneDictionary();
            phones.add(
                    new Person("Petr", "Arsentev", "534872", "Bryansk")
            );
            ArrayList<Person> persons = phones.find("Petr");
            assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }
}