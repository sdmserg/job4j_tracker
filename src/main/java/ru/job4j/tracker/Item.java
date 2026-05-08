package ru.job4j.tracker;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Item {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    private int id;

    private String name;

    @EqualsAndHashCode.Exclude
    private LocalDateTime created = LocalDateTime.now().withNano(0);

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

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                 + ", created=" + created.format(FORMATTER)
                + '}';
    }
}