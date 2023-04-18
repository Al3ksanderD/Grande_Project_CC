package com.codecool.el_projecto_grande.company.controlers;

import com.codecool.el_projecto_grande.company.dto.CompanyDTO;

import com.codecool.el_projecto_grande.company.dto.newDTO.NewCompanyDTO;
import com.codecool.el_projecto_grande.company.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/companies")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class companyController {

    private CompanyService companyService;

    @GetMapping()
    public List<CompanyDTO> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @PostMapping()
    public CompanyDTO createNewCompany(@RequestBody NewCompanyDTO newCompanyDTO){
        return companyService.saveNewCompany(newCompanyDTO);
    }

    @GetMapping("/id/{companyID}")
    public CompanyDTO getCompanyById(@PathVariable Long companyID){
        return companyService.getCompanyById(companyID);

    }

    @GetMapping("/city/{companyCity}")
    public List<CompanyDTO> getCompanyByCity(@PathVariable String companyCity){
        return companyService.getCompanyByCity(companyCity);

    }



}
