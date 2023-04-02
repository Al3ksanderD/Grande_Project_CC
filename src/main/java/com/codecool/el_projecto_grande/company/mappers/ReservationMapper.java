package com.codecool.el_projecto_grande.company.mappers;

import com.codecool.el_projecto_grande.company.dto.ReservationDTO;
import com.codecool.el_projecto_grande.company.dto.newDTO.NewReservationDTO;
import com.codecool.el_projecto_grande.company.entities.Employee;
import com.codecool.el_projecto_grande.company.entities.Reservations;
import com.codecool.el_projecto_grande.company.repositories.EmployeeRepository;
import com.codecool.el_projecto_grande.user.models.AppUser;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class ReservationMapper {


    public ReservationDTO reservationEntityToDTO(Reservations reservations){
        return new ReservationDTO(
                reservations.getId(),
                getIDAndName(reservations.getEmployee()),
                getIDAndName(reservations.getAppUser()),
                reservations.getDate(),
                reservations.getIsReserved()


        );
    }

    public Reservations reservationsDTOToEntity(NewReservationDTO newReservationDTO, Employee assigned_employee){
        return new Reservations(
                assigned_employee,
                newReservationDTO.getDate(),
                newReservationDTO.getIsReserved()
        );
    }

    private  IdAndNamePair getIDAndName(Employee employee) {
        return new IdAndNamePair(employee.getId(), employee.getName());
    }
    private  IdAndNamePair getIDAndName(AppUser appUser) {
        if(Objects.nonNull(appUser)){
            return new IdAndNamePair(appUser.getId(), appUser.getFirstName() + " " + appUser.getLastName());
        }
        return null;
    }

}
