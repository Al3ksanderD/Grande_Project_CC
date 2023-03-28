package com.codecool.el_projecto_grande.company.mappers;

import com.codecool.el_projecto_grande.company.dto.EmployeeDTO;
import com.codecool.el_projecto_grande.company.dto.newDTO.NewEmployeeDTO;
import com.codecool.el_projecto_grande.company.entities.Employee;
import com.codecool.el_projecto_grande.company.entities.OfferedServices;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EmployeeMapper {
    public EmployeeDTO EmployeeEntityToDTO(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getPosition(),
                employee.getDescription(),
                getCompanyNameAndId(employee),

                employee.getOfferedServices().stream()
                        .map(o -> getOfferedServiceNameAndId(o))
                        .collect(Collectors.toSet())
        );
    }



    public Employee EmployeeDTOToEntity(NewEmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.getName(),
                employeeDTO.getPosition(),
                employeeDTO.getDescription()
        );
    }
    private IdAndNamePair getOfferedServiceNameAndId(OfferedServices offeredService) {
        if(offeredService != null) {
            return new IdAndNamePair(offeredService.getId(), offeredService.getDescription());
        }
        return null;
    }
    private IdAndNamePair getCompanyNameAndId(Employee employee) {
        if(employee.getCompanyEmployedAt() != null) {
            return new IdAndNamePair(employee.getCompanyEmployedAt().getId(), employee.getCompanyEmployedAt().getName());
        }
        return null;
    }
}
