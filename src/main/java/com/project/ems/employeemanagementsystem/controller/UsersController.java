package com.project.ems.employeemanagementsystem.controller;

import com.project.ems.employeemanagementsystem.common.utils.ResponseWrapper;
import com.project.ems.employeemanagementsystem.dto.UsersDto;
import com.project.ems.employeemanagementsystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public ResponseWrapper<UsersDto> registerUser(@RequestBody UsersDto usersDto) {
        UsersDto response = usersService.registerUser(usersDto);
        return new ResponseWrapper<>(response,"Registered", HttpStatus.OK.value());
    }


}
