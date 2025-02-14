package com.project.ems.employeemanagementsystem.service.impl;

import com.project.ems.employeemanagementsystem.common.exception.AlreadyExistsException;
import com.project.ems.employeemanagementsystem.dto.UsersDto;
import com.project.ems.employeemanagementsystem.entity.Users;
import com.project.ems.employeemanagementsystem.mapper.UsersMapper;
import com.project.ems.employeemanagementsystem.repository.UsersRepo;
import com.project.ems.employeemanagementsystem.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepo usersRepo;


//    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public UsersServiceImpl(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    @Transactional
    public UsersDto registerUser(UsersDto usersDto) {
        Users userDb = usersRepo.findByUserName(usersDto.getUserName());
        if(userDb != null){
            throw new AlreadyExistsException("Already exists user");
        }
        Users user = UsersMapper.toEntity(usersDto);
        user.setUserName(usersDto.getUserName());
//        user.setPassword(passwordEncoder.encode(usersDto.getPassword()));
        usersRepo.save(user);

        return UsersMapper.toDto(user);
    }
}
