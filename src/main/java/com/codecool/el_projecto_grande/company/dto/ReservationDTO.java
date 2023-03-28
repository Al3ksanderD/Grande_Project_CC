package com.codecool.el_projecto_grande.company.dto;

import com.codecool.el_projecto_grande.company.mappers.IdAndNamePair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ReservationDTO {
    private Long id;
    private IdAndNamePair employee;
    private IdAndNamePair appUser;
    private LocalDateTime date;
    private Boolean isReserved;

}
