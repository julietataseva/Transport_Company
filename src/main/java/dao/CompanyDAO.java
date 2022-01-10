package dao;

import entity.Company;
import entity.Transportation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyDAO {
    public static void saveCompany(Company company) {
        if (company != null) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(company);
                transaction.commit();
            }
        }
    }

    public static List<Company> readCompanies() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT c FROM Company c", entity.Company.class).getResultList();
        }
    }

    public static void saveOrUpdateCompany(Company company) {
        if (company != null) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(company);
                transaction.commit();
            }
        }
    }

    public static void deleteCompany(Company company) {
        if (company != null) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(company);
                transaction.commit();
            }
        }
    }

    public static Company getCompany(int id) {
        Company company;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.get(Company.class, id);
            transaction.commit();
        }
        return company;
    }

    public static List<Company> filterByName(String name) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).where(cb.equal(root.get("name"), name));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> filterByIncome(BigDecimal income) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).where(cb.equal(root.get("income"), income));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> sortByName() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).orderBy(cb.asc(root.get("name")));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> sortByIncome() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).orderBy(cb.asc(root.get("income")));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static BigDecimal getIncomeFromDateToDate(Company company, LocalDateTime fromDate, LocalDateTime toDate) {
        if (company != null && fromDate != null && toDate != null) {
            List<Transportation> transportations = TransportationDAO.getTransportationsForCompanyFromDateToDate(company, fromDate, toDate);
            List<BigDecimal> transportationsPrice = transportations.stream().map(Transportation::getPrice).collect(Collectors.toList());
            BigDecimal sum = transportationsPrice.stream().reduce(BigDecimal.valueOf(0), BigDecimal::add);
            return sum;
        }
        return BigDecimal.valueOf(0);
    }

    public static BigDecimal getIncomeFromTransportations(Company company) {
        if (company != null) {
            List<Transportation> transportations = TransportationDAO.getTransportationsForCompany(company);
            List<BigDecimal> transportationsPrice = transportations.stream().map(Transportation::getPrice).collect(Collectors.toList());
            BigDecimal sum = transportationsPrice.stream().reduce(BigDecimal.valueOf(0), BigDecimal::add);
            return sum;
        }
        return BigDecimal.valueOf(0);
    }
}
