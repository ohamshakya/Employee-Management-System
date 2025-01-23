package com.project.employeemanagementsystem.ems.dto;

import com.project.employeemanagementsystem.ems.common.enums.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Integer id;

    @NotNull(message = "firstname is mandatory")
    private String firstName;

    @NotNull(message = "lastname is mandatory")
    private String lastName;

    @NotNull(message = "gender is mandatory")
    private Gender gender;

    @NotNull(message = "age is mandatory")
    private Integer age;

    @NotNull(message = "contact number is mandatory")
    private String contactNumber;

    @NotNull(message = "email is mandatory")
    private String email;
}
