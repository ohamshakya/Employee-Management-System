package com.project.ems.employeemanagementsystem.mapper;

import com.project.ems.employeemanagementsystem.dto.JobDepartmentDto;
import com.project.ems.employeemanagementsystem.dto.SalaryDto;
import com.project.ems.employeemanagementsystem.entity.JobDepartment;
import com.project.ems.employeemanagementsystem.entity.Salary;

import java.util.ArrayList;
import java.util.List;

public class JobDepartmentMapper {

    public static JobDepartment toEntity(JobDepartmentDto jobDepartmentDto) {
        JobDepartment jobDepartment = new JobDepartment();
        jobDepartment.setTitle(jobDepartmentDto.getTitle());
        jobDepartment.setDepartment(jobDepartmentDto.getDepartment());
        jobDepartment.setDescription(jobDepartmentDto.getDescription());
        jobDepartment.setSalaryRange(jobDepartmentDto.getSalaryRange());
        /// iterating in the array
        List<Salary> salaryList = new ArrayList<>();
        /// checking if the salaryList is null or not
        if (jobDepartmentDto.getSalaryDtoList() != null) {
            for (SalaryDto salaryDto : jobDepartmentDto.getSalaryDtoList()) {
                if (salaryDto != null) {
                    Salary salary = new Salary();
                    salary.setAmount(salaryDto.getAmount());
                    salary.setAnnual(salaryDto.getAnnual());
                    salary.setBonus(salaryDto.getBonus());
                    salary.setJobDepartment(jobDepartment);
                    salaryList.add(salary);
                }
            }
        }
        jobDepartment.setSalaryList(salaryList);
        return jobDepartment;
    }


    public static JobDepartmentDto toDto(JobDepartment jobDepartment) {
        JobDepartmentDto jobDepartmentDto = new JobDepartmentDto();
        jobDepartmentDto.setId(jobDepartment.getId());
        jobDepartmentDto.setTitle(jobDepartment.getTitle());
        jobDepartmentDto.setDepartment(jobDepartment.getDepartment());
        jobDepartmentDto.setDescription(jobDepartment.getDescription());
        jobDepartmentDto.setSalaryRange(jobDepartment.getSalaryRange());
        /// Iterating in the array
        List<SalaryDto> salaryDtoList = new ArrayList<>();
        if (jobDepartment.getSalaryList() != null) {
            for (Salary salary : jobDepartment.getSalaryList()) {
                if (salary != null) {
                    SalaryDto salaryDto = new SalaryDto();
                    salaryDto.setId(salary.getId());
                    salaryDto.setAmount(salary.getAmount());
                    salaryDto.setAnnual(salary.getAnnual());
                    salaryDto.setBonus(salary.getBonus());
                    salaryDtoList.add(salaryDto);
                }
            }
        }
        jobDepartmentDto.setSalaryDtoList(salaryDtoList);
        return jobDepartmentDto;
    }

}
