package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SortItemTest {

    @Test
    public void whenSortItemAsc() {
        List<Item> items = Arrays.asList(
                new Item(0, "Zero"),
                new Item(1, "One"),
                new Item(2, "Two"),
                new Item(4, "Four"),
                new Item(6, "Six")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(4, "Four"),
                new Item(1, "One"),
                new Item(6, "Six"),
                new Item(2, "Two"),
                new Item(0, "Zero")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenSortItemDesc() {
        List<Item> items = Arrays.asList(
                new Item(0, "Zero"),
                new Item(1, "One"),
                new Item(2, "Two"),
                new Item(4, "Four"),
                new Item(6, "Six")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(0, "Zero"),
                new Item(2, "Two"),
                new Item(6, "Six"),
                new Item(1, "One"),
                new Item(4, "Four")
        );
        assertThat(items).isEqualTo(expected);
    }
}