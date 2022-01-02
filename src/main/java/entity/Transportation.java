package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "transportation")
public class Transportation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_point", nullable = false)
    private String startPoint;

    @Column(name = "end_point", nullable = false)
    private String endPoint;

    @Column(name = "date_of_departure", nullable = false)
    private LocalDate dateOfDeparture;

    @Column(name = "date_of_arrival", nullable = false)
    private LocalDate dateOfArrival;

    @Column(name = "transportation_type", nullable = false)
    private TransportationType transportationType;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToMany
    private Set<Client> clients;

    public enum TransportationType {
        STOCK, PASSENGERS
    }

    public Transportation() {
    }

    public Transportation(int id, String startPoint, String endPoint,
                          LocalDate dateOfDeparture, LocalDate dateOfArrival,
                          TransportationType transportationType, BigDecimal weight,
                          BigDecimal price, Company company, Driver driver, Vehicle vehicle) {
        this.id = id;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.dateOfDeparture = dateOfDeparture;
        this.dateOfArrival = dateOfArrival;
        this.transportationType = transportationType;
        this.weight = weight;
        this.price = price;
        this.company = company;
        this.driver = driver;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public TransportationType getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(TransportationType transportationType) {
        this.transportationType = transportationType;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "id=" + id +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", dateOfDeparture=" + dateOfDeparture +
                ", dateOfArrival=" + dateOfArrival +
                ", transportationType=" + transportationType +
                ", weight=" + weight +
                ", price=" + price +
                ", company=" + company +
                ", driver=" + driver +
                ", vehicle=" + vehicle +
                '}';
    }
}
