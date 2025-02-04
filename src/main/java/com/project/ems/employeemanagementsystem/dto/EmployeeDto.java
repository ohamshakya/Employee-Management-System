package com.project.ems.employeemanagementsystem.dto;

import com.project.ems.employeemanagementsystem.common.enums.Gender;
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
public class EmployeeDto {
    private Integer id;

    @NotNull(message = "Firstname is mandatory")
    private String firstName;

    @NotNull(message = "Lastname is mandatory")
    private String lastName;

    @NotNull(message = "Gender is mandatory")
    private Gender gender;

    @NotNull(message = "Age is mandatory")
    private Integer age;

    @NotNull(message = "Contact number is mandatory")
    private String contactNumber;

    @NotNull(message = "email is mandatory")
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<LeaveDto> leavesDtoList;

    private List<QualificationDto> qualificationsDtoList;
}
