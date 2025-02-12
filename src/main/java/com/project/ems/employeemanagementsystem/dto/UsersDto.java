package com.project.ems.employeemanagementsystem.dto;

import jdk.jfr.SettingDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDto {
    private Integer id;

    private String userName;

    private String password;
}
