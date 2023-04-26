package com.codecool.el_projecto_grande.company.services;

import com.codecool.el_projecto_grande.company.dto.EmployeeDTO;
import com.codecool.el_projecto_grande.company.dto.newDTO.NewEmployeeDTO;
import com.codecool.el_projecto_grande.company.entities.Company;
import com.codecool.el_projecto_grande.company.entities.Employee;
import com.codecool.el_projecto_grande.company.mappers.EmployeeMapper;
import com.codecool.el_projecto_grande.company.repositories.CompanyRepository;
import com.codecool.el_projecto_grande.company.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private CompanyRepository companyRepository;
    private EmployeeMapper employeeMapper;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAllBy().stream()
                .map(d -> employeeMapper.EmployeeEntityToDTO(d))
                .toList();

    }

    public EmployeeDTO addNewEmployee(NewEmployeeDTO newEmployeeDTO) {
        Employee entity = employeeMapper.EmployeeDTOToEntity(newEmployeeDTO);
        Employee savedEmployee = employeeRepository.save(entity);
        return employeeMapper.EmployeeEntityToDTO(savedEmployee);
    }

    public void assignEmployeeToCompany(Long employeeID, Long companyID) {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Company company = companyRepository.findById(companyID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        employee.assignCompany(company);
        company.addEmployee(employee);

        companyRepository.save(company);

    }

    public EmployeeDTO getEmployeeById(Long employeeID) {
        Employee entity = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return employeeMapper.EmployeeEntityToDTO(entity);
    }

    public List<EmployeeDTO> getAllEmployeesByCompany(Long companyID) {
        return employeeRepository.findAllByCompany(companyID).stream()
                .map(d -> employeeMapper.EmployeeEntityToDTO(d))
                .toList();
    }
}
