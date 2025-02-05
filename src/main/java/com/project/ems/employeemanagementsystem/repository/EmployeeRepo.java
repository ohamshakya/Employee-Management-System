package com.project.ems.employeemanagementsystem.repository;

import com.project.ems.employeemanagementsystem.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    Employee findEmployeeByFirstName(String firstName);

    @Query("SELECT e FROM Employee e where LOWER(e.firstName) LIKE LOWER(CONCAT('%', :query, '%'))OR LOWER(e.firstName) LIKE LOWER(CONCAT('%', :query, '%') ) ")
    Page<Employee> searchEmployee(@Param("query") String employeeName, Pageable pageable);

}
