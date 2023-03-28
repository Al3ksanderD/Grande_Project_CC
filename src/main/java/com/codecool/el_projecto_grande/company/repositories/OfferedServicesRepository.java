package com.codecool.el_projecto_grande.company.repositories;

import com.codecool.el_projecto_grande.company.entities.Company;
import com.codecool.el_projecto_grande.company.entities.Employee;
import com.codecool.el_projecto_grande.company.entities.OfferedServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OfferedServicesRepository extends JpaRepository<OfferedServices, Long>{

    @Query("SELECT DISTINCT e from OfferedServices e LEFT JOIN FETCH e.employeeOfferingThisService")
    List<OfferedServices> findAllBy();

    @Query("SELECT DISTINCT e from OfferedServices e LEFT JOIN FETCH e.employeeOfferingThisService" +
            " WHERE e.employeeOfferingThisService.id = :id ")
    List<OfferedServices> findAllByEmployeeID(Long id);

    @Query("SELECT d from OfferedServices d LEFT JOIN FETCH d.employeeOfferingThisService WHERE d.id = :id")
    Optional<OfferedServices> findOneById(Long id);


}
