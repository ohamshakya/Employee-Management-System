package com.project.ems.employeemanagementsystem.mapper;

import com.project.ems.employeemanagementsystem.dto.EmployeeDto;
import com.project.ems.employeemanagementsystem.dto.LeaveDto;
import com.project.ems.employeemanagementsystem.dto.QualificationDto;
import com.project.ems.employeemanagementsystem.entity.Employee;
import com.project.ems.employeemanagementsystem.entity.Leave;
import com.project.ems.employeemanagementsystem.entity.Qualification;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {

    //employee to entity mapper take input from employeeDto and convert to entity
    public static Employee toEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setGender(employeeDto.getGender());
        employee.setAge(employeeDto.getAge());
        employee.setContactNumber(employeeDto.getContactNumber());
        employee.setEmail(employeeDto.getEmail());
        //list of leaves because to add newly created Leave.
        List<Leave> leaves = new ArrayList<>();
        //checking null pointer
        if (employeeDto.getLeavesDtoList() != null) {
            for (LeaveDto leaveDto : employeeDto.getLeavesDtoList()) {
                //setting up leave
                Leave leave = new Leave();
                leave.setId(leaveDto.getId());
                leave.setReason(leaveDto.getReason());
                leave.setDate(leaveDto.getDate());
                leave.setEmployee(employee);
                leaves.add(leave);
            }
        }
        List<Qualification> qualifications = new ArrayList<>();
        //checking null pointer
        if (employeeDto.getQualificationsDtoList() != null) {
            for (QualificationDto qualificationDto : employeeDto.getQualificationsDtoList()) {
                if(qualificationDto != null){
                    Qualification qualification = new Qualification();
                    qualification.setId(qualificationDto.getId());
                    qualification.setPosition(qualificationDto.getPosition());
                    qualification.setRequirements(qualificationDto.getRequirements());
                    qualification.setDateIn(qualificationDto.getDateIn());
                    qualification.setEmployee(employee);
                    qualifications.add(qualification);
                }
            }
        }
        employee.setQualifications(qualifications);
        employee.setLeaves(leaves);

        return employee;
    }

    // Take out result from the employee Db and show it through the employeeDto
    public static EmployeeDto toDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setGender(employee.getGender());
        employeeDto.setAge(employee.getAge());
        employeeDto.setContactNumber(employee.getContactNumber());
        employeeDto.setEmail(employee.getEmail());
        List<LeaveDto> leavesDto = new ArrayList<>();
        if (employee.getLeaves() != null) {
            for (Leave leave : employee.getLeaves()) {
                if (leave != null) {
                    LeaveDto leaveDto = new LeaveDto();
                    leaveDto.setId(leave.getId());
                    leaveDto.setReason(leave.getReason());
                    leaveDto.setDate(leave.getDate());
                    leavesDto.add(leaveDto);
                }
            }
        }

        List<QualificationDto> qualificationDtos = new ArrayList<>();
        //checking null pointer
        if (employee.getQualifications() != null) {
            for (Qualification qualification : employee.getQualifications()) {
                if (qualification != null) {
                    QualificationDto qualificationDto = new QualificationDto();
                    qualificationDto.setId(qualification.getId());
                    qualificationDto.setPosition(qualification.getPosition());
                    qualificationDto.setRequirements(qualification.getRequirements());
                    qualificationDto.setDateIn(qualification.getDateIn());
                    qualificationDtos.add(qualificationDto);
                }
            }
        }
        employeeDto.setLeavesDtoList(leavesDto);
        employeeDto.setQualificationsDtoList(qualificationDtos);
        employeeDto.setCreatedAt(employee.getCreatedAt());
        employeeDto.setUpdatedAt(employee.getUpdatedAt());

        return employeeDto;
    }
}
