package com.project.employeemanagementsystem.ems.mapper;

import com.project.employeemanagementsystem.ems.dto.EmployeeDto;
import com.project.employeemanagementsystem.ems.entity.Employee;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setGender(employeeDto.getGender());
        employee.setAge(employeeDto.getAge());
        employee.setContactNumber(employeeDto.getContactNumber());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }

    public static EmployeeDto toDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setGender(employee.getGender());
        employeeDto.setAge(employee.getAge());
        employeeDto.setContactNumber(employee.getContactNumber());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }
}
