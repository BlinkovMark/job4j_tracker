package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(-4, 4, x -> x * x);
        List<Double> expected = Arrays.asList(16D, 9D, 4D, 1D, 0D, 1D, 4D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(1, 7, x -> Math.pow(5, x));
        List<Double> expected = Arrays.asList(5D, 25D, 125D, 625D, 3125D, 15625D);
        assertThat(result, is(expected));
    }
}