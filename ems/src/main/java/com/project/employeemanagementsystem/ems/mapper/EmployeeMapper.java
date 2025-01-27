package com.project.employeemanagementsystem.ems.mapper;

import com.project.employeemanagementsystem.ems.dto.EmployeeDto;
import com.project.employeemanagementsystem.ems.dto.LeaveDto;
import com.project.employeemanagementsystem.ems.entity.Employee;
import com.project.employeemanagementsystem.ems.entity.Leave;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setGender(employeeDto.getGender());
        employee.setAge(employeeDto.getAge());
        employee.setContactNumber(employeeDto.getContactNumber());
        employee.setEmail(employeeDto.getEmail());
        List<Leave> leaves = new ArrayList<>();
         for (LeaveDto leaveDto : employeeDto.getLeaveDtoList()) {
                if(leaveDto != null){
                    Leave leave = new Leave();
                    leave.setReason(leaveDto.getReason());
                    leave.setEmployee(employee);
                    leaves.add(leave);
                }
         }
        employee.setLeave(leaves);
        return employee;

    }

    public static EmployeeDto toDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setGender(employee.getGender());
        employeeDto.setAge(employee.getAge());
        employeeDto.setContactNumber(employee.getContactNumber());
        employeeDto.setEmail(employee.getEmail());
        List<LeaveDto> leaveDtos = new ArrayList<>();
        for(Leave leave : employee.getLeave()){
            if(leave != null){
                LeaveDto leaveDto = new LeaveDto();
                leaveDto.setReason(leave.getReason());
                leaveDtos.add(leaveDto);
            }
        }
        employeeDto.setLeaveDtoList(leaveDtos);

        return employeeDto;
    }

    public static Employee toUpdateEmployee(EmployeeDto employeeDto){
        return null;
    }
}
