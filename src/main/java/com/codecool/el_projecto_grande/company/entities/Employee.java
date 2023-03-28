package com.codecool.el_projecto_grande.company.entities;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String name;
    private String position;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)

    private Company companyEmployedAt;
    @OneToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            orphanRemoval = true

    )
//    Jak coś nie będzie działać to zakomentuj znowu ten join table
    @JoinTable(
            name = "employee_offered_services",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "offered_service_id")
    )
    private Set<OfferedServices> offeredServices = new HashSet<>();
    @OneToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            orphanRemoval = true

    )
    @JoinTable(
            name = "employee_reservations_services",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_reservation_id")
    )
    private List<Reservations> reservations;

    public Employee(String name, String position, String description) {
        this.name = name;
        this.position = position;
        this.description = description;
    }

    public void assignCompany(Company company) {
        this.companyEmployedAt = company;
    }

    public void addOfferedService(OfferedServices offeredService) {
        offeredServices.add(offeredService);
    }
}
