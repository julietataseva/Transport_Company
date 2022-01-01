package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "has_paid", nullable = false)
    private boolean hasPaid;

    @ManyToMany
    private Set<Transportation> transportations;
}
