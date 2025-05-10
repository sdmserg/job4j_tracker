package ru.job4j.tracker;

import java.util.List;

import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class DeleteAllItems implements UserAction {
    private final Output out;

    public DeleteAllItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete all items.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete all items. ===");
        List<Item> allItems = tracker.findAll();
        List<Integer> collect = allItems.stream()
                .map(Item::getId).toList();
        for (Integer integer : collect) {
            tracker.delete(integer);
        }
        out.println("=== Все заявки удалены. ===");
        return true;
    }
}
