package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByName() {
        Comparator<Job> cmp = new ByNameSort();
        int rsl = cmp.compare(
                new Job("first", 0),
                new Job("second", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameReverse() {
        Comparator<Job> cmp = new ByNameSortReverse();
        int rsl = cmp.compare(
                new Job("first", 0),
                new Job("second", 1));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriority() {
        Comparator<Job> cmp = new ByPrioritySort();
        int rsl = cmp.compare(
                new Job("first", 0),
                new Job("second", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityReverse() {
        Comparator<Job> cmp = new ByPrioritySortReverse();
        int rsl = cmp.compare(
                new Job("first", 0),
                new Job("second", 1));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmp = new ByNameSort().thenComparing(new ByPrioritySort());
        int rsl = cmp.compare(
                new Job("item", 0),
                new Job("item", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityReverse() {
        Comparator<Job> cmp = new ByNameSortReverse().thenComparing(new ByPrioritySortReverse());
        int rsl = cmp.compare(
                new Job("item", 0),
                new Job("item", 1));
        assertThat(rsl, greaterThan(0));
    }
}