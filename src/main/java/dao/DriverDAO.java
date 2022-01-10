package dao;

import entity.Driver;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class DriverDAO {
    public static void saveDriver(Driver driver) {
        if (driver != null) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(driver);
                transaction.commit();
            }
        }
    }

    public static List<Driver> readDrivers() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT d FROM Driver d", entity.Driver.class).getResultList();
        }
    }

    public static void saveOrUpdateDriver(Driver driver) {
        if (driver != null) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(driver);
                transaction.commit();
            }
        }
    }

    public static void deleteDriver(Driver driver) {
        if (driver != null) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(driver);
                transaction.commit();
            }
        }
    }

    public static Driver getDriver(int id) {
        Driver driver;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            driver = session.get(Driver.class, id);
            transaction.commit();
        }
        return driver;
    }

    public static List<Driver> filterByQualificationType(Driver.QualificationType qualificationType) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);
            cr.select(root).where(cb.equal(root.get("qualificationType"), qualificationType));

            Query<Driver> query = session.createQuery(cr);
            List<Driver> drivers = query.getResultList();
            return drivers;
        }
    }

    public static List<Driver> filterBySalary(BigDecimal salary) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);
            cr.select(root).where(cb.equal(root.get("salary"), salary));

            Query<Driver> query = session.createQuery(cr);
            List<Driver> drivers = query.getResultList();
            return drivers;
        }
    }

    public static List<Driver> sortByQualificationType() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);
            cr.select(root).orderBy(cb.asc(root.get("qualificationType")));

            Query<Driver> query = session.createQuery(cr);
            List<Driver> drivers = query.getResultList();
            return drivers;
        }
    }

    public static List<Driver> sortBySalary() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);
            cr.select(root).orderBy(cb.asc(root.get("salary")));

            Query<Driver> query = session.createQuery(cr);
            List<Driver> drivers = query.getResultList();
            return drivers;
        }
    }
}
