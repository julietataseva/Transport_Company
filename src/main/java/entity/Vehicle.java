package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "vehicle_type", nullable = false)
    private VehicleType vehicleType;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "vehicle")
    private List<Transportation> transportations;

    public enum VehicleType {
        BUS, TRUCK, TANK
    }
}
