package com.project.ems.employeemanagementsystem.service.impl;

import com.project.ems.employeemanagementsystem.common.exception.ResourceNotFoundException;
import com.project.ems.employeemanagementsystem.dto.JobDepartmentDto;
import com.project.ems.employeemanagementsystem.dto.SalaryDto;
import com.project.ems.employeemanagementsystem.entity.JobDepartment;
import com.project.ems.employeemanagementsystem.entity.Salary;
import com.project.ems.employeemanagementsystem.mapper.JobDepartmentMapper;
import com.project.ems.employeemanagementsystem.repository.JobDepartmentRepo;
import com.project.ems.employeemanagementsystem.service.JobDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JobDepartmentServiceImpl implements JobDepartmentService {
    private JobDepartmentRepo jobDepartmentRepo;

    public JobDepartmentServiceImpl(JobDepartmentRepo jobDepartmentRepo) {
        this.jobDepartmentRepo = jobDepartmentRepo;
    }

    @Override
    @Transactional
    public JobDepartmentDto saveJobDepartment(JobDepartmentDto jobDepartmentDto) {
        log.info("Job Department save : service");
        JobDepartment jobDepartment = JobDepartmentMapper.toEntity(jobDepartmentDto);
        jobDepartmentRepo.save(jobDepartment);
        return JobDepartmentMapper.toDto(jobDepartment);
    }

    @Override
    @Transactional
    public JobDepartmentDto updateJobDepartment(JobDepartmentDto jobDepartmentDto, Integer id) {
        JobDepartment existingJobDepartment = jobDepartmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job Department not found"));
        existingJobDepartment.setTitle(jobDepartmentDto.getTitle());
        existingJobDepartment.setDepartment(jobDepartmentDto.getDepartment());
        existingJobDepartment.setDescription(jobDepartmentDto.getDescription());
        existingJobDepartment.setSalaryRange(jobDepartmentDto.getSalaryRange());
        existingJobDepartment.getSalaryList().clear();
        List<Salary> updatedList = new ArrayList<>();
        for (SalaryDto salary : jobDepartmentDto.getSalaryDtoList()) {
            if (salary != null) {
            }
        }
//        List<Salary> updatedSalaryList = jobDepartmentDto.getSalaryDtoList().stream().map(dto -> Salary.builder()
//                .id(dto.getId())
//                .amount(dto.getAmount())
//                .annual(dto.getAnnual())
//                .bonus(dto.getBonus())
//                .jobDepartment(existingJobDepartment)
//                .build())
//                .toList();
        jobDepartmentRepo.save(existingJobDepartment);
        return jobDepartmentDto;
    }

    @Override
    public JobDepartmentDto getJobDepartmentById(Integer id) {
        log.info("Job Department getEmployeeById : service");
        JobDepartment jobDepartment = jobDepartmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job department not found"));
        return JobDepartmentMapper.toDto(jobDepartment);
    }

    @Override
    @Transactional
    public void deleteJobDepartment(Integer id) {
        log.info("Job Department delete : service");
        JobDepartment jobDepartment = jobDepartmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job department not found"));
        jobDepartmentRepo.delete(jobDepartment);

    }

    @Override
    public List<JobDepartmentDto> getJobDepartments() {
        log.info("Job Department getJobDepartments : service");
        List<JobDepartment> jobDepartments = jobDepartmentRepo.findAll();
        return jobDepartments.stream().map(JobDepartmentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<JobDepartmentDto> getJobDepartments(Pageable pageable) {
        log.info("inside get job departments : service");
        Page<JobDepartment> jobDepartments = jobDepartmentRepo.findAll(pageable);
        return jobDepartments.map(JobDepartmentMapper::toDto);
    }
}
