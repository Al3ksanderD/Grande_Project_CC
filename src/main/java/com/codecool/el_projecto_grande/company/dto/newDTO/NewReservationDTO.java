package com.codecool.el_projecto_grande.company.dto.newDTO;

import com.codecool.el_projecto_grande.company.mappers.IdAndNamePair;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class NewReservationDTO {
    private Long employee_id;
    private LocalDateTime date;
    private Boolean isReserved = false;

    public NewReservationDTO(Long employee, LocalDateTime date) {
        this.employee_id = employee;
        this.date = date;
    }
}


