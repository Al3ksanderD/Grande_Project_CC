package com.codecool.el_projecto_grande.company.dto;

import com.codecool.el_projecto_grande.company.entities.Employee;
import com.codecool.el_projecto_grande.company.mappers.IdAndNamePair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OfferedServicesDTO {
    private Long id;
    private IdAndNamePair employeeOfferingThisService;
    private Integer price;
    private  String description;
}
