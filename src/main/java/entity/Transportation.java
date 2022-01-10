package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
    private LocalDateTime dateOfDeparture;

    @Column(name = "date_of_arrival", nullable = false)
    private LocalDateTime dateOfArrival;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "transportation_client",
            joinColumns = {
                    @JoinColumn(name = "transportations_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "clients_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Client> clients = new HashSet<>();

    public enum TransportationType {
        STOCK, PASSENGERS
    }

    public Transportation() {
    }

    public Transportation(String startPoint, String endPoint,
                          LocalDateTime dateOfDeparture, LocalDateTime dateOfArrival,
                          TransportationType transportationType, BigDecimal weight,
                          BigDecimal price, Company company, Driver driver, Vehicle vehicle) {
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

    public LocalDateTime getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDateTime dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public LocalDateTime getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDateTime dateOfArrival) {
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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
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
