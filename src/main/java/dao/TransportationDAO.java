package dao;

import entity.Company;
import entity.Transportation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransportationDAO {
    public static void saveTransportation(Transportation transportation) {
        if (transportation != null) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(transportation);
                transaction.commit();
            }
        }
    }

    public static List<Transportation> readTransportations() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT t FROM Transportation t", entity.Transportation.class).getResultList();
        }
    }

    public static void saveOrUpdateTransportation(Transportation transportation) {
        if (transportation != null) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(transportation);
                transaction.commit();
            }
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

    public static List<Transportation> filterByEndPoint(String endPoint) {
        if (endPoint != null) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<Transportation> cr = cb.createQuery(Transportation.class);
                Root<Transportation> root = cr.from(Transportation.class);
                cr.select(root).where(cb.equal(root.get("endPoint"), endPoint));

                Query<Transportation> query = session.createQuery(cr);
                List<Transportation> transportations = query.getResultList();
                return transportations;
            }
        }
        return new ArrayList<>();
    }

    public static List<Transportation> sortByEndPoint() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Transportation> cr = cb.createQuery(Transportation.class);
            Root<Transportation> root = cr.from(Transportation.class);
            cr.select(root).orderBy(cb.asc(root.get("endPoint")));

            Query<Transportation> query = session.createQuery(cr);
            List<Transportation> transportations = query.getResultList();
            return transportations;
        }
    }

    public static List<Transportation> getTransportationsForCompany(Company company) {
        if (company != null) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<Transportation> cr = cb.createQuery(Transportation.class);
                Root<Transportation> root = cr.from(Transportation.class);
                cr.select(root).where(cb.equal(root.get("company"), company.getId()));

                Query<Transportation> query = session.createQuery(cr);
                List<Transportation> transportations = query.getResultList();
                return transportations;
            }
        }
        return new ArrayList<Transportation>();
    }

    public static List<Transportation> getTransportationsForCompanyFromDateToDate
            (Company company, LocalDateTime fromDate, LocalDateTime toDate) {
        if (company != null && fromDate != null && toDate != null) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<Transportation> cr = cb.createQuery(Transportation.class);
                Root<Transportation> root = cr.from(Transportation.class);

                Predicate predicateForBetweenDates =
                        cb.between(root.get("dateOfDeparture"), fromDate, toDate) ;
                Predicate predicateForCompany =
                        cb.equal(root.get("company"), company.getId());

                Predicate finalPredicate
                        = cb.and(predicateForBetweenDates, predicateForCompany);
                cr.where(finalPredicate);
                List<Transportation> transportations = session.createQuery(cr).getResultList();

                return transportations;
            }
        }
        return new ArrayList<Transportation>();
    }
}
