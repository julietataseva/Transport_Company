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

    public Vehicle() {
    }

    public Vehicle(int id, VehicleType vehicleType, Company company) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleType=" + vehicleType +
                ", company=" + company +
                '}';
    }
}
