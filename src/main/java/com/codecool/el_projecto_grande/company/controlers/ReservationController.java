package com.codecool.el_projecto_grande.company.controlers;


import com.codecool.el_projecto_grande.company.entities.Reservations;
import com.codecool.el_projecto_grande.company.services.ReservationsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/reservation")
@AllArgsConstructor
public class ReservationController {
    private ReservationsService reservationsService;

    @GetMapping
    public List<Reservations> getAllReservations(){
        return reservationsService.getAllReservations();
    }


}
