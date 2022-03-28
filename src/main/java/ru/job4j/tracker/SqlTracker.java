package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;
    private static final Logger LOG = LoggerFactory.getLogger(SqlTracker.class.getName());

    public SqlTracker() {
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.prepareStatement(
                "insert into items (name,created) values (?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            LOG.error("add", e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rez = false;
        try (PreparedStatement ps = cn.prepareStatement(
                "update items set name=?, created=? where id=?")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.setInt(3, id);
            rez = ps.executeUpdate() > 0;
        } catch (Exception e) {
            LOG.error("replace", e);
        }
        return rez;
    }

    @Override
    public boolean delete(int id) {
        boolean rez = false;
        try (PreparedStatement ps = cn.prepareStatement(
                "delete from items where id=?")) {
            ps.setInt(1, id);
            rez = ps.executeUpdate() > 0;
        } catch (Exception e) {
            LOG.error("delete", e);
        }
        return rez;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = ps.executeQuery()) {
                Item item;
                while ((item = findItem(resultSet)) != null) {
                    items.add(item);
                }
            }
        } catch (Exception e) {
            LOG.error("add", e);
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("select * from items where name=?")) {
            ps.setString(1, key);
            try (ResultSet resultSet = ps.executeQuery()) {
                Item item;
                while ((item = findItem(resultSet)) != null) {
                    items.add(item);
                }
            }
        } catch (Exception e) {
            LOG.error("findByName", e);
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement ps = cn.prepareStatement("select * from items where id=?")) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                item = findItem(resultSet);
            }
        } catch (Exception e) {
            LOG.error("findById", e);
        }
        return item;
    }

    private Item findItem(ResultSet resultSet) throws SQLException {
        Item item = null;
        if (resultSet.next()) {
            item = new Item(
                    resultSet.getString(2),
                    resultSet.getInt(1),
                    resultSet.getTimestamp(3).toLocalDateTime()
            );
        }
        return item;
    }
}
