package entity;

import javax.persistence.*;
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
    private double weight;

    @Column(name = "price")
    private double price;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToMany(mappedBy = "transportations")
    private Set<Client> clients;

    public enum TransportationType {
        STOCK, PASSENGERS
    }
}
