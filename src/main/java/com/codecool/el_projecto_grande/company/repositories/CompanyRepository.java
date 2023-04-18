package com.codecool.el_projecto_grande.company.repositories;

import com.codecool.el_projecto_grande.company.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT DISTINCT c from Company c LEFT JOIN FETCH c.employees")
    List<Company> findAllBy();

    @Query("SELECT DISTINCT c from Company c LEFT JOIN FETCH c.employees WHERE c.city = :companyCity")
    List<Company> findByCity(String companyCity);
}
