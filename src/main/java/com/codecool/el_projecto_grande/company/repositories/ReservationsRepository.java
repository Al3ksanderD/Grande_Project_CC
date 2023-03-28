package com.codecool.el_projecto_grande.company.repositories;

import com.codecool.el_projecto_grande.company.entities.OfferedServices;
import com.codecool.el_projecto_grande.company.entities.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
}
