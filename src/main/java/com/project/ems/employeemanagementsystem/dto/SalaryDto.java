package com.project.ems.employeemanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalaryDto {
    private Integer id;

    @NotNull(message = "amount is mandatory")
    private String amount;

    @NotNull(message = "annual is mandatory")
    private String annual;

    @NotNull(message = "bonus is mandatory")
    private String bonus;

    @JsonIgnore
    private JobDepartmentDto jobDepartmentDto;
}
