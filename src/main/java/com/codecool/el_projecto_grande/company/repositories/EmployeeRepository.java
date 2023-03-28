package com.codecool.el_projecto_grande.company.repositories;

import com.codecool.el_projecto_grande.company.entities.Company;
import com.codecool.el_projecto_grande.company.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT DISTINCT e from Employee e LEFT JOIN FETCH e.companyEmployedAt")
    List<Employee> findAllBy();
}
