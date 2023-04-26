package com.codecool.el_projecto_grande.company.controlers;

import com.codecool.el_projecto_grande.company.dto.EmployeeDTO;
import com.codecool.el_projecto_grande.company.dto.newDTO.NewEmployeeDTO;
import com.codecool.el_projecto_grande.company.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/employees")
@AllArgsConstructor
public class employeeController {
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/company/{id}")
    public List<EmployeeDTO> getAllEmployeesByCompany(@PathVariable Long companyID){
        return employeeService.getAllEmployeesByCompany(companyID);
    }

    @PostMapping
    public EmployeeDTO addNewEmployee(@RequestBody NewEmployeeDTO newEmployeeDTO){
        return employeeService.addNewEmployee(newEmployeeDTO);
    }

    @GetMapping("/{employeeID}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeID){
        return employeeService.getEmployeeById(employeeID);

    }

    @PutMapping("/{employeeID}/companies/{companyID}")
    public void assignEmployeeToCompany(@PathVariable Long employeeID, @PathVariable Long companyID){
        employeeService.assignEmployeeToCompany(employeeID, companyID);
    }

}
