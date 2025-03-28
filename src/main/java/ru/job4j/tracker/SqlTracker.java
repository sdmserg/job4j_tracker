package ru.job4j.tracker;

import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader().
                getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
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

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO items (name, created) VALUES (?, ?);",
                PreparedStatement.RETURN_GENERATED_KEYS
        )) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.execute();
            try (ResultSet generatedId = preparedStatement.getGeneratedKeys()) {
                if (generatedId.next()) {
                    item.setId(generatedId.getInt("id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error adding item: " + e.getMessage());
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE items SET name = ?, created = ? WHERE id = ?;"
        )) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.setInt(3, id);
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error replacing item: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement prepareStatement = connection.prepareStatement(
                "DELETE FROM items WHERE id = ?;"
        )) {
            prepareStatement.setInt(1, id);
            prepareStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error deleting item: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM items;"
        )) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(Item.fromDataBase(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created")
                                    .toLocalDateTime()

                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error findAll items: " + e.getMessage());
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM items WHERE name = ?;"
        )) {
            preparedStatement.setString(1, key);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(Item.fromDataBase(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").
                                    toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error find item by key: " + e.getMessage());
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM items WHERE id = ?;"
        )) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Item.fromDataBase(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created")
                                    .toLocalDateTime()
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error find item by id: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
