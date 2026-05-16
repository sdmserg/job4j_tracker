package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
            return item;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error adding item", e);
        }
    }

    @Override
    public boolean replace(int id, Item item) {
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            int rowsUpdate = session.createQuery(
                    "UPDATE Item SET name = :fName, "
                            + "created = :fCreated WHERE id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate();
            transaction.commit();
            return rowsUpdate > 0;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error replacing item", e);
        }
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            session.createQuery(
                    "DELETE FROM Item WHERE id =:fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting item", e);
        }
    }

    @Override
    public List<Item> findAll() {
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            List<Item> items = session.createQuery(
                    "FROM Item", Item.class)
                    .list();
            transaction.commit();
            return items;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error findAll items", e);
        }
    }

    @Override
    public List<Item> findByName(String key) {
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            List<Item> items = session.createQuery(
                    "FROM Item WHERE name = :fName", Item.class)
                    .setParameter("fName", key)
                    .list();
            transaction.commit();
            return items;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error find item by key", e);
        }
    }

    @Override
    public Item findById(int id) {
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            Item item = session.createQuery(
                    "FROM Item WHERE id = :fId", Item.class)
                    .setParameter("fId", id)
                    .uniqueResult();
            transaction.commit();
            return item;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error find item by id", e);
        }
    }

    @Override
    public void close() {
        sf.close();
        StandardServiceRegistryBuilder.destroy(registry);
    }
}