package com.codecool.el_projecto_grande.company.dto;

import com.codecool.el_projecto_grande.company.entities.Company;
import com.codecool.el_projecto_grande.company.entities.OfferedServices;
import com.codecool.el_projecto_grande.company.mappers.IdAndNamePair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String position;
    private String description;
    private IdAndNamePair companyName;
    private Set<IdAndNamePair> offeredServices;
}
