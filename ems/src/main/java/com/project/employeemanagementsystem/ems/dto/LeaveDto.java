package com.project.employeemanagementsystem.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeaveDto {
    private Integer id;

    private String reason;

    private EmployeeDto employees;

}
