//package com.project.ems.employeemanagementsystem.security;
//
//import com.project.ems.employeemanagementsystem.entity.Users;
//import com.project.ems.employeemanagementsystem.repository.UsersRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//
//    private UsersRepo usersRepo;
//
//
//
//    public MyUserDetailService(UsersRepo usersRepo) {
//        this.usersRepo = usersRepo;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users userDB = usersRepo.findByUserName(username);
//        if(userDB == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new UserPrincipal();
//    }
//}
