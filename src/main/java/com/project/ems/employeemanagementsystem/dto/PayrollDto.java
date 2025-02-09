package com.project.ems.employeemanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PayrollDto {
    private Integer id;

    private LocalDateTime date;

    private String report;

    private BigDecimal totalAmount;

    @JsonIgnore
    private EmployeeDto employeeDto;

    @JsonIgnore
    private JobDepartmentDto jobDepartmentDto;

    @JsonIgnore
    private LeaveDto leaveDto;
}
