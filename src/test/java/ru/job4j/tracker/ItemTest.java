package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemTest {

    @Test
    public void whenSort() {
        List<Item> item = Arrays.asList(
                new Item("second"),
                new Item("third"),
                new Item("first"));
        Collections.sort(item, new Sort());
        assertThat(item.get(0).getName(), is("first"));
        assertThat(item.get(1).getName(), is("second"));
        assertThat(item.get(2).getName(), is("third"));
    }

    @Test
    public void whenReverseSort() {
        List<Item> item = Arrays.asList(
                new Item("first"),
                new Item("third"),
                new Item("second"));
        Collections.sort(item, new ReverseSort());
        assertThat(item.get(0).getName(), is("third"));
        assertThat(item.get(1).getName(), is("second"));
        assertThat(item.get(2).getName(), is("first"));
    }
}
