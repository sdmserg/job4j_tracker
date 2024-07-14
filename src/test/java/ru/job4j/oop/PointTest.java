package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class PointTest {

    @Test
    public void when216To123Then3Dot316() {
        Point a = new Point(2, 1, 6);
        Point b = new Point(1, 2, 3);
        double result = a.distance3D(b);
        double expected = 3.316;
        assertThat(result).isEqualTo(expected, offset(0.001));
    }

    @Test
    public void whenMinus428ToMinus614Then4Dot582() {
        Point a = new Point(-4, 2, 8);
        Point b = new Point(-6, 1, 4);
        double result = a.distance3D(b);
        double expected = 4.582;
        assertThat(result).isEqualTo(expected, offset(0.001));
    }

    @Test
    public void when234To123Then1Dot732() {
        Point a = new Point(2, 3, 4);
        Point b = new Point(1, 2, 3);
        double result = a.distance3D(b);
        double expected = 1.732;
        assertThat(result).isEqualTo(expected, offset(0.001));
    }

    @Test
    public void when111To111Then0() {
        Point a = new Point(1, 1, 1);
        Point b = new Point(1, 1, 1);
        double result = a.distance3D(b);
        double expected = 0;
        assertThat(result).isEqualTo(expected, offset(0.001));
    }
}