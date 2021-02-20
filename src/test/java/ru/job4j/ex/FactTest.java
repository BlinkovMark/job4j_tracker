package ru.job4j.ex;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenError() {
        Fact.calc(-1);
    }

    @Test
    public void when720() {
        int rsl = Fact.calc(6);
        assertThat(rsl, is(720));
    }
}
