package com.codecool.el_projecto_grande.company.controlers;


import com.codecool.el_projecto_grande.company.dto.newDTO.NewOfferedServiceDTO;
import com.codecool.el_projecto_grande.company.dto.OfferedServicesDTO;
import com.codecool.el_projecto_grande.company.services.OfferedServicesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/services")
@AllArgsConstructor
public class OfferedServicesController {

    private OfferedServicesService offeredServicesService;

    @PostMapping
    public OfferedServicesDTO addNewOfferedService(@RequestBody NewOfferedServiceDTO newOfferedServiceDTO){
        return offeredServicesService.addNewOfferedService(newOfferedServiceDTO);
    }

    @GetMapping
    public List<OfferedServicesDTO> getAllServices() {
        return offeredServicesService.getAllServices();
    }


    @GetMapping("/employees/{id}")
    public List<OfferedServicesDTO> getAllServicesByEmployeeID(@PathVariable Long id) {
        return offeredServicesService.getAllServicesByEmployeeID(id);
    }

    @GetMapping("/{id}")
    public OfferedServicesDTO getServiceByID(@PathVariable Long id) {
        return offeredServicesService.getServiceById(id);
    }

    @PutMapping("/{serviceId}/employees/{employeeID}")
    public void assignServiceToEmployee(@PathVariable Long serviceId, @PathVariable Long employeeID){
        offeredServicesService.assignServiceToEmployee(serviceId, employeeID);
    }

}
