package com.codecool.el_projecto_grande.user.repositories;


import com.codecool.el_projecto_grande.company.entities.Reservations;
import com.codecool.el_projecto_grande.user.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
@Transactional(readOnly = true)
public interface UserRepository
        extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);

    @Query("SELECT DISTINCT e from AppUser e LEFT JOIN FETCH e.userReservations" +
            " WHERE e.id = :id ")
    Optional<AppUser> findByID(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);

}
