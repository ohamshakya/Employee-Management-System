package com.project.employeemanagementsystem.ems.service.impl;

import com.project.employeemanagementsystem.ems.common.exception.ResourceNotFoundException;
import com.project.employeemanagementsystem.ems.dto.EmployeeDto;
import com.project.employeemanagementsystem.ems.entity.Employee;
import com.project.employeemanagementsystem.ems.mapper.EmployeeMapper;
import com.project.employeemanagementsystem.ems.repository.EmployeeRepo;
import com.project.employeemanagementsystem.ems.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        log.info("create service");
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setGender(employeeDto.getGender());
        employee.setAge(employeeDto.getAge());
        employee.setContactNumber(employeeDto.getContactNumber());
        employee.setEmail(employeeDto.getEmail());
        employeeRepo.save(employee);
        return EmployeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto, Integer id) {
        log.info("Inside update service");
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        existingEmployee.setFirstName(employeeDto.getFirstName());
        existingEmployee.setLastName(employeeDto.getLastName());
        existingEmployee.setGender(employeeDto.getGender());
        existingEmployee.setAge(employeeDto.getAge());
        existingEmployee.setContactNumber(employeeDto.getContactNumber());
        existingEmployee.setEmail(employeeDto.getEmail());
        employeeRepo.save(existingEmployee);
        return EmployeeMapper.toDto(existingEmployee);
    }

    @Override
    public void delete(Integer id) {
        log.info("Inside delete service");
        employeeRepo.deleteById(id);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
       Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOt found"));
       return EmployeeMapper.toDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(EmployeeMapper::toDto).collect(Collectors.toList());
    }
}
