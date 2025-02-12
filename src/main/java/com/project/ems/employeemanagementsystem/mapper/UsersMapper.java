package com.project.ems.employeemanagementsystem.mapper;

import com.project.ems.employeemanagementsystem.dto.UsersDto;
import com.project.ems.employeemanagementsystem.entity.Users;

public class UsersMapper {
    public static Users toEntity(UsersDto usersDto){
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setUserName(usersDto.getUserName());
        users.setPassword(usersDto.getPassword());
        return users;
    }

    public static UsersDto toDto(Users users){
        UsersDto usersDto = new UsersDto();
        usersDto.setId(users.getId());
        usersDto.setUserName(users.getUserName());
        usersDto.setPassword(users.getPassword());
        return usersDto;
    }

}
