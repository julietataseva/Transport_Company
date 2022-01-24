package entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "qualification_type", nullable = false)
    private QualificationType qualificationType;

    @Positive
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "driver")
    private List<Transportation> transportations;

    public enum QualificationType {
        LEGAL_CAPACITY_TO_TRANSPORT_SPECIAL_CARGO,
        TRANSPORTATION_OF_MORE_THAN_12_PEOPLE
    }

    public Driver() {
    }

    public Driver(String name, QualificationType qualificationType, BigDecimal salary, Company company) {
        this.name = name;
        this.qualificationType = qualificationType;
        this.salary = salary;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QualificationType getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(QualificationType qualificationType) {
        this.qualificationType = qualificationType;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qualificationType=" + qualificationType +
                ", salary=" + salary +
                ", company=" + company +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id == driver.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
