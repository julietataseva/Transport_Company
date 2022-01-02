package dao;

import entity.Transportation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TransportationDAO {
    public static void saveTransportation(Transportation transportation) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(transportation);
            transaction.commit();
        }
    }

    public static List<Transportation> readTransportations() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT t FROM Transportation t", entity.Transportation.class).getResultList();
        }
    }

    public static void saveOrUpdateTransportation(Transportation transportation) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(transportation);
            transaction.commit();
        }
    }

    public static void deleteTransportation(Transportation transportation) {
        if (transportation != null) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(transportation);
                transaction.commit();
            }
        }
    }

    public static Transportation getTransportation(int id) {
        Transportation transportation;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transportation = session.get(Transportation.class, id);
            transaction.commit();
        }
        return transportation;
    }
}
