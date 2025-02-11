package com.project.ems.employeemanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.ems.employeemanagementsystem.common.enums.Status;
import com.project.ems.employeemanagementsystem.entity.Employee;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class AttendanceDto {

    private Integer id;

    private LocalDateTime date;

    private LocalTime timeIn;

    private LocalTime timeOut;

    private Status status;

    @JsonIgnore
    private EmployeeDto employeeDto;
}
