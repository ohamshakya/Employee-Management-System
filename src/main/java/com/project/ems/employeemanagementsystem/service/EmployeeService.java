package com.project.ems.employeemanagementsystem.service;

import com.project.ems.employeemanagementsystem.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto, Integer id);

    List<EmployeeDto> getAllEmployees();

    void deleteEmployee(Integer id);

    EmployeeDto getEmployeeById(Integer id);

    Page<EmployeeDto> getEmployees(Pageable pageable);

    Page<EmployeeDto> searchEmployeeByFirstname(String firstName, Pageable pageable);
}
