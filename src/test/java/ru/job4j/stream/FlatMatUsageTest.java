package ru.job4j.stream;

import java.util.List;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FlatMatUsageTest {
    @Test
    public void whenMatrixToList() {
        FlatMapUsage usage = new FlatMapUsage();
        List<List<Integer>> list = List.of(
                List.of(1, 4, 7, 9, 3, 2, 10, 0),
                List.of(2, 6, 11, 7, 5, 1, 8, 4));
        List<Integer> expected = List.of(1, 4, 7, 9, 3, 2, 10, 0, 2, 6, 11, 7, 5, 1, 8, 4);
        assertThat(usage.toMap(list), is(expected));
    }
}
