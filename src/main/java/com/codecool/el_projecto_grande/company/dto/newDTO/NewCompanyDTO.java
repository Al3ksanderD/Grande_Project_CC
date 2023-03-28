package com.codecool.el_projecto_grande.company.dto.newDTO;

import com.codecool.el_projecto_grande.company.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class NewCompanyDTO {
    private String name;
    private String position;
    private String description;
}
