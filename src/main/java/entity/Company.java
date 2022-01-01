package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "income", nullable = false)
    private double income;

    @OneToMany(mappedBy = "company")
    private List<Driver> drivers;

    @OneToMany(mappedBy = "company")
    private List<Transportation> transportations;

    @OneToMany(mappedBy = "company")
    private List<Vehicle> vehicles;
}
