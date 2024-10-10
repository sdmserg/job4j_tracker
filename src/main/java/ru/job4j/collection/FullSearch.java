package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public Set<String> extractNumber(List<Task> tasks) {
        HashSet<String> numbers = new HashSet<>();
        for (Task task : tasks) {
            numbers.add(task.getNumber());
        }
        return numbers;
    }
}
