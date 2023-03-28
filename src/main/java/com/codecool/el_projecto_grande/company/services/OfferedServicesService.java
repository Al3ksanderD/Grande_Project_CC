package com.codecool.el_projecto_grande.company.services;

import com.codecool.el_projecto_grande.company.dto.newDTO.NewOfferedServiceDTO;
import com.codecool.el_projecto_grande.company.dto.OfferedServicesDTO;
import com.codecool.el_projecto_grande.company.entities.Employee;
import com.codecool.el_projecto_grande.company.entities.OfferedServices;
import com.codecool.el_projecto_grande.company.mappers.OfferedServicesMapper;
import com.codecool.el_projecto_grande.company.repositories.EmployeeRepository;
import com.codecool.el_projecto_grande.company.repositories.OfferedServicesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class OfferedServicesService {
    private OfferedServicesRepository offeredServicesRepository;
    private EmployeeRepository employeeRepository;
    private OfferedServicesMapper offeredServicesMapper;
    public List<OfferedServicesDTO> getAllServices() {
        return offeredServicesRepository.findAllBy().stream()
                .map(o -> offeredServicesMapper.offeredServicesEntityToDTO(o))
                .toList();
    }

    public List<OfferedServicesDTO> getAllServicesByEmployeeID(Long employeeID) {
        return offeredServicesRepository.findAllByEmployeeID(employeeID).stream()
                .map(o -> offeredServicesMapper.offeredServicesEntityToDTO(o))
                .toList();
    }

    public OfferedServicesDTO getServiceById(Long id) {
        return offeredServicesRepository.findOneById(id)
                .map(o -> offeredServicesMapper.offeredServicesEntityToDTO(o))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void assignServiceToEmployee(Long serviceId, Long employeeID) {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        OfferedServices offeredService = offeredServicesRepository.findById(serviceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        offeredService.assignEmployee(employee);
        employee.addOfferedService(offeredService);


        employeeRepository.save(employee);
    }

    public OfferedServicesDTO addNewOfferedService(NewOfferedServiceDTO newOfferedServiceDTO) {
        OfferedServices offeredServices = offeredServicesMapper.offeredServicesDTOTOEntity(newOfferedServiceDTO);
        OfferedServices savedService = offeredServicesRepository.save(offeredServices);
        return offeredServicesMapper.offeredServicesEntityToDTO(savedService);
    }
}
