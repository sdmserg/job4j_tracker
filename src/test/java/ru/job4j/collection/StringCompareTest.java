package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCompareTest {

    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenFirstCharOfLeftIsLowerThanShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "ivanov",
                "Ivanov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenFirstCharOfRightIsLowerThanShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "ivanov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftIsEmptyThanShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "",
                "Ivanov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenRightIsEmptyThanShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                ""
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenBothAreEmptyThanShouldBeZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "",
                ""
        );
        assertThat(result).isEqualTo(0);
    }
}