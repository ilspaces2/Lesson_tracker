package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HmbTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean deleteAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        boolean rzl = session.createQuery("delete from Item").executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return rzl;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        boolean rzl = session.createQuery("update Item i set i.name=:nName, i.created=:nCreated where i.id=:nId")
                .setParameter("nName", item.getName())
                .setParameter("nCreated", item.getCreated())
                .setParameter("nId", id)
                .executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return rzl;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        boolean rzl = session.createQuery("delete from Item where id=:nId")
                .setParameter("nId", id)
                .executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return rzl;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List rzl = session.createQuery("from Item").getResultList();
        session.getTransaction().commit();
        session.close();
        return rzl;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        List rzl = session.createQuery("from Item where name=:nName")
                .setParameter("nName", key)
                .list();
        session.getTransaction().commit();
        session.close();
        return rzl;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item rzl = (Item) session.createQuery(" from Item where id=:nId")
                .setParameter("nId", id)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return rzl;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
