package com.codecool.el_projecto_grande.company.mappers;

import com.codecool.el_projecto_grande.company.dto.CompanyDTO;
import com.codecool.el_projecto_grande.company.dto.newDTO.NewCompanyDTO;
import com.codecool.el_projecto_grande.company.entities.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyDTO companyEntityToDTO(Company company){
        return new CompanyDTO(
                company.getId(),
                company.getName(),
                company.getDescription(),
                company.getEmployees().stream()
                        .map(d -> new IdAndNamePair(d.getId(), d.getName()))
                        .toList(),
                company.getCity()
        );
    }

    public Company companyDTOToEntity(NewCompanyDTO companyDTO){
        return new Company(
                companyDTO.getName(),
                companyDTO.getDescription(),
                companyDTO.getCity()
        );
    }
}
