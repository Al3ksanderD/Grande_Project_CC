package com.codecool.el_projecto_grande.company.services;

import com.codecool.el_projecto_grande.company.dto.ReservationDTO;
import com.codecool.el_projecto_grande.company.entities.Reservations;
import com.codecool.el_projecto_grande.company.mappers.ReservationMapper;
import com.codecool.el_projecto_grande.company.repositories.ReservationsRepository;
import com.codecool.el_projecto_grande.user.models.AppUser;
import com.codecool.el_projecto_grande.user.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservationsService {
    private ReservationsRepository reservationsRepository;
    private UserRepository userRepository;
    private ReservationMapper reservationMapper;
    public List<Reservations> getAllReservations() {
        return reservationsRepository.findAll();
    }

    public List<ReservationDTO> getAllReservationsByEmployee(Long employeeID) {
        return reservationsRepository.findAllByEmployeeID(employeeID).stream()
                .map(r -> reservationMapper.reservationEntityToDTO(r) )
                .toList();
    }

    public List<ReservationDTO> getAllReservationsByUser(Long appUserID) {
        return reservationsRepository.findAllByUserID(appUserID).stream()
                .map(r -> reservationMapper.reservationEntityToDTO(r))
                .toList();
    }

    public void assignUserToReservation(Long reservationID, Long userID) {
        Reservations reservations = reservationsRepository.findByID(reservationID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        AppUser appUser = userRepository.findByID(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        reservations.addUser(appUser);
        appUser.addReservation(reservations);

        userRepository.save(appUser);
    }
}
