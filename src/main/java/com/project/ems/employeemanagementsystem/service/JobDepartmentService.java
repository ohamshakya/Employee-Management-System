package com.project.ems.employeemanagementsystem.service;

import com.project.ems.employeemanagementsystem.dto.JobDepartmentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobDepartmentService {
    JobDepartmentDto saveJobDepartment(JobDepartmentDto jobDepartmentDto);

    JobDepartmentDto updateJobDepartment(JobDepartmentDto jobDepartmentDto, Integer id);

    JobDepartmentDto getJobDepartmentById(Integer id);

    void deleteJobDepartment(Integer id);

    List<JobDepartmentDto> getJobDepartments();

    Page<JobDepartmentDto> getJobDepartments(Pageable pageable);

}
