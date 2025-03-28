package ru.job4j.tracker.store;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().
                getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItemAndFindByIdThenMustBeSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("first");
        Item second = new Item("second");
        tracker.add(first);
        tracker.replace(first.getId(), second);
        assertThat(tracker.findById(first.getId()).getName()).isEqualTo(second.getName());
        assertThat(tracker.findById(first.getId()).getCreated()).isEqualTo(second.getCreated());
    }

    @Test
    public void whenDeleteItemByIdAndFindByIdWhenIsNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenAddItemsAndFindAllThenReturnAllItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> items = tracker.findAll();
        assertThat(items).isNotEmpty()
                .hasSize(3)
                .containsExactly(first, second, third);
    }

    @Test
    public void whenAddItemsAndFindByNameThenReturnAllItemsWithName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("first");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> items = tracker.findByName(first.getName());
        assertThat(items).isNotEmpty()
                .hasSize(2)
                .containsExactly(first, third);
    }

    @Test
    public void whenAddItemsAndFindByIdThenReturnItemWithId() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        Item result = tracker.findById(third.getId());
        assertThat(result).isEqualTo(third);
    }
}
