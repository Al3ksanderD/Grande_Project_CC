package com.codecool.el_projecto_grande.company.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class OfferedServices {
    @SequenceGenerator(
            name = "offered_services_sequence",
            sequenceName = "offered_services_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "offered_services_sequence"
    )
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employeeOfferingThisService;

    private Integer price;
    private  String description;

    public OfferedServices(Integer price, String description) {
        this.price = price;
        this.description = description;
    }

    public void assignEmployee(Employee employee) {
        employeeOfferingThisService = employee;
    }
}
