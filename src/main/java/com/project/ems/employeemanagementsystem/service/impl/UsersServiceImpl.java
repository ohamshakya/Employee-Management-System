package com.project.ems.employeemanagementsystem.service.impl;

import com.project.ems.employeemanagementsystem.common.exception.AlreadyExistsException;
import com.project.ems.employeemanagementsystem.dto.UsersDto;
import com.project.ems.employeemanagementsystem.entity.Users;
import com.project.ems.employeemanagementsystem.mapper.UsersMapper;
import com.project.ems.employeemanagementsystem.repository.UsersRepo;
import com.project.ems.employeemanagementsystem.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersRepo usersRepo;

    private BCryptPasswordEncoder  encoder;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepo usersRepo, BCryptPasswordEncoder encoder) {
        this.usersRepo = usersRepo;
        this.encoder = encoder;
    }

    @Override
    public UsersDto registerUser(UsersDto usersDto) {
        Users userDb = usersRepo.findByUsername(usersDto.getUserName());
        if(userDb != null){
            throw new AlreadyExistsException("Already exists user");
        }
        Users user = UsersMapper.toEntity(usersDto);
        user.setUserName(usersDto.getUserName());
        user.setPassword(passwordEncoder.encode(usersDto.getPassword()));

        return UsersMapper.toDto(user);
    }
}
