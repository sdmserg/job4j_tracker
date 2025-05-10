package ru.job4j.tracker;

import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class CreateManyItems implements UserAction {
    private final Output out;

    public CreateManyItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many items.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create many items. ===");
        int count = input.askInt("Введите количество заявок: ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Заявка № " + i));
        }
        out.println("Создано заявок: " + count);
        return true;
    }
}