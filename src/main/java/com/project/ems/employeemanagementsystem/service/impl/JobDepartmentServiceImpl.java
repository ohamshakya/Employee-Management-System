package com.project.ems.employeemanagementsystem.service.impl;

import com.project.ems.employeemanagementsystem.common.exception.ResourceNotFoundException;
import com.project.ems.employeemanagementsystem.dto.JobDepartmentDto;
import com.project.ems.employeemanagementsystem.dto.PayrollDto;
import com.project.ems.employeemanagementsystem.dto.SalaryDto;
import com.project.ems.employeemanagementsystem.entity.JobDepartment;
import com.project.ems.employeemanagementsystem.entity.Payroll;
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
import java.util.Optional;
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
        if(jobDepartmentDto.getSalaryDtoList() != null){
            existingJobDepartment.getSalaryList().clear();
            List<Salary> updatedSalary = new ArrayList<>();
            for(SalaryDto salaryDto : jobDepartmentDto.getSalaryDtoList()){
                if(salaryDto != null){
                    Salary salary = new Salary();
//                    if(salaryDto.getId() != null){
//                        salary.setId(salaryDto.getId());
//                    }
                    salary.setAnnual(salaryDto.getAnnual());
                    salary.setAmount(salaryDto.getAmount());
                    salary.setBonus(salaryDto.getBonus());
                    salary.setJobDepartment(existingJobDepartment);
                    updatedSalary.add(salary);
                }
            }
            existingJobDepartment.getSalaryList().addAll(updatedSalary);
        }

        if (jobDepartmentDto.getPayrollDtoList() != null) {
            // Clear existing payrolls
            existingJobDepartment.getPayrollList().clear();

            // Map and add new payrolls
            List<Payroll> updatedPayrolls = new ArrayList<>();
            for (PayrollDto payrollDto : jobDepartmentDto.getPayrollDtoList()) {
                if (payrollDto != null) {
                    Payroll payroll = new Payroll();
//                    if (payrollDto.getId() != null) {
//                        payroll.setId(payrollDto.getId());
//                    }
                    payroll.setDate(payrollDto.getDate());
                    payroll.setReport(payrollDto.getReport());
                    payroll.setTotalAmount(payrollDto.getTotalAmount());
                    payroll.setJobDepartment(existingJobDepartment);
                    updatedPayrolls.add(payroll);
                }
            }
            existingJobDepartment.getPayrollList().addAll(updatedPayrolls);
        }

        // Save and convert back to DTO
        JobDepartment updatedJobDepartment = jobDepartmentRepo.save(existingJobDepartment);

        jobDepartmentRepo.save(updatedJobDepartment);
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
