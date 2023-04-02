package com.codecool.el_projecto_grande.company.controlers;


import com.codecool.el_projecto_grande.company.dto.ReservationDTO;
import com.codecool.el_projecto_grande.company.dto.newDTO.NewReservationDTO;
import com.codecool.el_projecto_grande.company.entities.Reservations;
import com.codecool.el_projecto_grande.company.services.ReservationsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/reservation")
@AllArgsConstructor
public class ReservationController {
    private ReservationsService reservationsService;

    @PostMapping
    public ReservationDTO addNewReservation(@RequestBody NewReservationDTO newReservationDTO){
        return reservationsService.addNewReservation(newReservationDTO);
    }

    @GetMapping
    public List<ReservationDTO> getAllReservations(){
        return reservationsService.getAllReservations();
    }

    @GetMapping("/employee/{employeeID}")
    public List<ReservationDTO> getAllReservationsByEmployee(@PathVariable Long employeeID){
        return reservationsService.getAllReservationsByEmployee(employeeID);
    }

    @GetMapping("/user/{userID}")
    public List<ReservationDTO> getAllReservationsByUser(@PathVariable Long appUserID){
        return reservationsService.getAllReservationsByUser(appUserID);
    }

    @PutMapping("/reseravtions/{reservationID}/user/{userID}")
    public void assignUserToReservation(@PathVariable Long reservationID, @PathVariable Long userID){
        reservationsService.assignUserToReservation(reservationID, userID);
    }

}
