package com.project.ems.employeemanagementsystem.repository;

import com.project.ems.employeemanagementsystem.entity.JobDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDepartmentRepo extends JpaRepository<JobDepartment, Integer> {
}
