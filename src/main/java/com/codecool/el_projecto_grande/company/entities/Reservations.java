package com.codecool.el_projecto_grande.company.entities;

import com.codecool.el_projecto_grande.user.models.AppUser;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservations {
    @SequenceGenerator(
            name = "reservations_sequence",
            sequenceName = "reservations_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservations_sequence"
    )
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser appUser;
    private LocalDateTime date;
    private Boolean isReserved;

    public Reservations(Employee assigned_employee, LocalDateTime date, Boolean isReserved) {
        this.employee = assigned_employee;
        this.date = date;
        this.isReserved = isReserved;
    }

    public void addUser(AppUser newAppUser) {
        appUser = newAppUser;
        isReserved = true;
    }
}
