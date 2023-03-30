package com.codecool.el_projecto_grande.company.repositories;

import com.codecool.el_projecto_grande.company.entities.OfferedServices;
import com.codecool.el_projecto_grande.company.entities.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
    @Query("SELECT DISTINCT e from Reservations e LEFT JOIN FETCH e.employee LEFT JOIN FETCH e.appUser" +
            " WHERE e.employee.id = :id ")
    List<Reservations> findAllByEmployeeID(Long id);

    @Query("SELECT DISTINCT e from Reservations e LEFT JOIN FETCH e.employee LEFT JOIN FETCH e.appUser" +
            " WHERE e.appUser.id = :id ")
    List<Reservations> findAllByUserID(Long id);

    @Query("SELECT DISTINCT e from Reservations e LEFT JOIN FETCH e.employee LEFT JOIN FETCH e.appUser" +
            " WHERE e.id = :id ")
    Optional<Reservations> findByID(Long id);
}
