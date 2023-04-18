package com.codecool.el_projecto_grande.company.dto;

import com.codecool.el_projecto_grande.company.entities.Employee;
import com.codecool.el_projecto_grande.company.mappers.IdAndNamePair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class CompanyDTO {
    private Long id;
    private String name;
    private String description;
    private List<IdAndNamePair> employees;
    private String city;
}
