package com.project.employeemanagementsystem.ems.controller;

import com.project.employeemanagementsystem.ems.common.utils.Messages;
import com.project.employeemanagementsystem.ems.common.utils.ResponseWrapper;
import com.project.employeemanagementsystem.ems.dto.EmployeeDto;
import com.project.employeemanagementsystem.ems.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseWrapper<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto response = employeeService.create(employeeDto);
        return new ResponseWrapper<>(response, Messages.EMPLOYEE_ADDED_SUCCESSFULLY, HttpStatus.CREATED.value());
    }

    @DeleteMapping("{id}")
    public ResponseWrapper<Object> deleteEmployee(@PathVariable Integer id){
      employeeService.delete(id);
      return new ResponseWrapper<>(null,Messages.EMPLOYEE_DELETED_SUCCESSFULLY,HttpStatus.OK.value());
    }

    @PutMapping("{id}")
    public ResponseWrapper<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable Integer id){
        log.info("Update Employee: controller");
        EmployeeDto response = employeeService.update(employeeDto,id);
        return new ResponseWrapper<>(response,Messages.EMPLOYEE_UPDATED_SUCCESSFULLY,HttpStatus.OK.value());
    }

    @GetMapping("{id}")
    public ResponseWrapper<EmployeeDto> getEmployeeById(@PathVariable Integer id){
        log.info("Get Employee by id: controller");
        EmployeeDto response = employeeService.getEmployeeById(id);
        return new ResponseWrapper<>(response,Messages.EMPLOYEE_RETRIEVED_SUCCESSFULLy,HttpStatus.OK.value());
    }

    @GetMapping
    public ResponseWrapper<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployee();
        return new ResponseWrapper<>(employeeDtos,Messages.EMPLOYEE_RETRIEVED_SUCCESSFULLy,HttpStatus.OK.value());
    }
}
