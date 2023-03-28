package com.codecool.el_projecto_grande.company.mappers;

import com.codecool.el_projecto_grande.company.dto.newDTO.NewOfferedServiceDTO;
import com.codecool.el_projecto_grande.company.dto.OfferedServicesDTO;
import com.codecool.el_projecto_grande.company.entities.Employee;
import com.codecool.el_projecto_grande.company.entities.OfferedServices;
import org.springframework.stereotype.Component;

@Component
public class OfferedServicesMapper {

    public OfferedServicesDTO offeredServicesEntityToDTO(OfferedServices offeredServices) {
        return new OfferedServicesDTO(
                offeredServices.getId(),
                getNameAndID(offeredServices.getEmployeeOfferingThisService()),
                offeredServices.getPrice(),
                offeredServices.getDescription()
        );
    }

    public OfferedServices offeredServicesDTOTOEntity(NewOfferedServiceDTO offeredServicesDTO){
        return new OfferedServices(
                offeredServicesDTO.getPrice(),
                offeredServicesDTO.getDescription()
        );
    }

    public IdAndNamePair getNameAndID(Employee employee){
        if (employee != null) {
            return new IdAndNamePair(employee.getId(),  employee.getName());
        }
        return null;
    }


}
