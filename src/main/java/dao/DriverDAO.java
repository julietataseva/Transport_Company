package dao;

import entity.Driver;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DriverDAO {
    public static void saveDriver(Driver driver) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(driver);
            transaction.commit();
        }
    }

    public static List<Driver> readDrivers() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT d FROM Driver d", entity.Driver.class).getResultList();
        }
    }

    public static void saveOrUpdateDriver(Driver driver) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(driver);
            transaction.commit();
        }
    }

    public static void deleteDriver(Driver driver) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(driver);
            transaction.commit();
        }
    }
}
