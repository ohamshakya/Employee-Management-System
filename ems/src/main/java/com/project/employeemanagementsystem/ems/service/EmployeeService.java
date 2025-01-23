package com.project.employeemanagementsystem.ems.service;

import com.project.employeemanagementsystem.ems.dto.EmployeeDto;
import com.project.employeemanagementsystem.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto,Integer id);

    void delete(Integer id);

    EmployeeDto getEmployeeById(Integer id);

    List<EmployeeDto> getAllEmployee();
}
