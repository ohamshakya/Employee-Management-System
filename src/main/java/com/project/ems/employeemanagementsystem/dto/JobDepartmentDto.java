package com.project.ems.employeemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobDepartmentDto {
    private Integer id;

    private String title;

    private String department;

    private String description;

    private Long SalaryRange;

    private List<SalaryDto> salaryDtoList;

    private List<PayrollDto> payrollDtoList;
}
