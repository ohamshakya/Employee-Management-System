package com.project.ems.employeemanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeaveDto {

    private Integer id;

    @NotNull(message = "reason is mandatory")
    private String reason;

    @NotNull(message = "date is mandatory")
    private LocalDateTime date;

    @JsonIgnore
    private EmployeeDto employeeDto;

    private List<PayrollDto> payrollDtoList;
}
