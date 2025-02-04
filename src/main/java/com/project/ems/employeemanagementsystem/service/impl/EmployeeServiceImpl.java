package com.project.ems.employeemanagementsystem.service.impl;

import com.project.ems.employeemanagementsystem.common.exception.AlreadyExistsException;
import com.project.ems.employeemanagementsystem.common.exception.ResourceNotFoundException;
import com.project.ems.employeemanagementsystem.common.utils.Messages;
import com.project.ems.employeemanagementsystem.dto.EmployeeDto;
import com.project.ems.employeemanagementsystem.entity.Employee;
import com.project.ems.employeemanagementsystem.mapper.EmployeeMapper;
import com.project.ems.employeemanagementsystem.repository.EmployeeRepo;
import com.project.ems.employeemanagementsystem.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        log.info("Employee save : service");
        Employee employeeFirstName = employeeRepo.findEmployeeByFirstName(employeeDto.getFirstName());
        if (employeeFirstName != null) {
            throw new AlreadyExistsException(Messages.EMPLOYEE_ALREADY_EXISTS);
        }
        Employee employee = EmployeeMapper.toEntity(employeeDto);
        employeeRepo.save(employee);
        return EmployeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto, Integer id) {
        return null;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(EmployeeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(Integer id) {
        log.info("Inside delete employee : service");
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Messages.EMPLOYEE_NOT_FOUND));
        employeeRepo.delete(employee);

    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        log.info("Employee get : service");
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Messages.EMPLOYEE_NOT_FOUND));
        return EmployeeMapper.toDto(employee);
    }

    @Override
    public Page<EmployeeDto> getEmployees(Pageable pageable) {
        Page<Employee> employeeDtos = employeeRepo.findAll(pageable);
        return employeeDtos.map(EmployeeMapper::toDto);
    }

    @Override
    public Page<EmployeeDto> searchEmployeeByFirstname(String firstName, Pageable pageable) {
        Page<Employee> employeeSearch = employeeRepo.searchEmployee(firstName, pageable);
        return employeeSearch.map(EmployeeMapper::toDto);
    }
}
