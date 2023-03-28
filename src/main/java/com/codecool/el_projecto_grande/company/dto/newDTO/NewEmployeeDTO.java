package com.codecool.el_projecto_grande.company.dto.newDTO;

import com.codecool.el_projecto_grande.company.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewEmployeeDTO {
    private String name;
    private String position;
    private String description;
}
