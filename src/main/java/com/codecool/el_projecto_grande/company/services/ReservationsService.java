package com.codecool.el_projecto_grande.company.services;

import com.codecool.el_projecto_grande.company.entities.Reservations;
import com.codecool.el_projecto_grande.company.repositories.ReservationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsService {
    private ReservationsRepository reservationsRepository;
    public List<Reservations> getAllReservations() {
        return reservationsRepository.findAll();
    }
}
