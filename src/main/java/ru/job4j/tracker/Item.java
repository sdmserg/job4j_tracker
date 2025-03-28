package ru.job4j.tracker;

import java.util.Objects;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Item {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    private int id;

    private String name;

    private LocalDateTime created = LocalDateTime.now().withNano(0);

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Item fromDataBase(int id, String name, LocalDateTime created) {
        Item item = new Item(id, name);
        item.created = created;
        return item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                 + ", created=" + created.format(FORMATTER)
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null | getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.getId() && name.equals(item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}