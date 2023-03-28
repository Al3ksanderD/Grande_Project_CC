package com.codecool.el_projecto_grande.company.services;

import com.codecool.el_projecto_grande.company.dto.CompanyDTO;
import com.codecool.el_projecto_grande.company.dto.newDTO.NewCompanyDTO;
import com.codecool.el_projecto_grande.company.entities.Company;
import com.codecool.el_projecto_grande.company.mappers.CompanyMapper;
import com.codecool.el_projecto_grande.company.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    CompanyRepository companyRepository;
    CompanyMapper companyMapper;
    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAllBy().stream()
                .map(d -> companyMapper.companyEntityToDTO(d))
                .toList();
    }

    public CompanyDTO saveNewCompany(NewCompanyDTO newCompanyDTO) {
        Company entity = companyMapper.companyDTOToEntity(newCompanyDTO);
        Company savedCompany = companyRepository.save(entity);
        return companyMapper.companyEntityToDTO(savedCompany);
    }

    public CompanyDTO getCompanyById(Long companyID) {
        Company entity = companyRepository.findById(companyID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return companyMapper.companyEntityToDTO(entity);
    }
}
