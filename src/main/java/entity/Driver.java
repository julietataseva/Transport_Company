package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "qualification_type", nullable = false)
    private QualificationType qualificationType;

    @Column(name = "salary", nullable = false)
    private double salary;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "driver")
    private List<Transportation> transportations;

    public enum QualificationType {
        LEGAL_CAPACITY_TO_TRANSPORT_SPECIAL_CARGO,
        TRANSPORTATION_OF_MORE_THAN_12_PEOPLE
    }
}
