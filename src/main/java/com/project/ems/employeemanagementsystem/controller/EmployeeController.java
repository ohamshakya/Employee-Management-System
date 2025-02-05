package com.project.ems.employeemanagementsystem.controller;


import com.project.ems.employeemanagementsystem.common.utils.Messages;
import com.project.ems.employeemanagementsystem.common.utils.PaginationUtil;
import com.project.ems.employeemanagementsystem.common.utils.ResponseWrapper;
import com.project.ems.employeemanagementsystem.dto.EmployeeDto;
import com.project.ems.employeemanagementsystem.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("api/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private EmployeeService employeeService;

    //for default pagination
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final String SORT_BY = "updatedAt";
    public static final String SORT_ORDER = "ASC";

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseWrapper<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        log.info("Inside createEmployee : controller");
        EmployeeDto employeeDto1 = employeeService.save(employeeDto);
        return new ResponseWrapper<>(employeeDto1, Messages.EMPLOYEE_ADDED_SUCCESSFULLY, HttpStatus.CREATED.value());
    }

    @GetMapping("{id}")
    public ResponseWrapper<EmployeeDto> getEmployee(@PathVariable Integer id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseWrapper<>(employeeDto, Messages.EMPLOYEE_RETRIEVED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @GetMapping()
    public ResponseWrapper<Object> getAllEmployees(@RequestParam("query") Optional<String> firstName,
                                                   @RequestParam("page") Optional<Integer> page,
                                                   @RequestParam("size") Optional<Integer> size,
                                                   @RequestParam("sortBy") Optional<String> sortBy,
                                                   @RequestParam("sortOrder") Optional<String> sortOrder) {
        log.info("Inside getAll Employees with query and page : controller");

        Pageable pageable = PaginationUtil.preparePaginationRequest(
                page,
                size.orElse(DEFAULT_PAGE_SIZE),
                sortBy.orElse(SORT_BY),
                sortOrder.orElse(SORT_ORDER)

        );

        String q;
        Object response;

        if (page.isPresent()) {
            response = employeeService.getEmployees(pageable);
        } else if (firstName.isPresent()) {
            q = firstName.get();
            response = employeeService.searchEmployeeByFirstname(q, pageable);
        } else {
            response = employeeService.getAllEmployees();
        }

        return new ResponseWrapper<>(response, Messages.EMPLOYEE_RETRIEVED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @DeleteMapping("{id}")
    public ResponseWrapper<Object> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseWrapper<>(null, Messages.EMPLOYEE_RETRIEVED_SUCCESSFULLY, HttpStatus.OK.value());


    }

}
