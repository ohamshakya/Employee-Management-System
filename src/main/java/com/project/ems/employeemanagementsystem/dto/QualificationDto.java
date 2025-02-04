package com.project.ems.employeemanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QualificationDto {
    private Integer id;

    @NotNull(message = "position is mandatory")
    private String position;

    @NotNull(message = "requirements is mandatory")
    private String requirements;

    @NotNull(message = "dateIn is mandatory")
    private LocalDateTime dateIn;

    @JsonIgnore
    private EmployeeDto employeeDto;
}
