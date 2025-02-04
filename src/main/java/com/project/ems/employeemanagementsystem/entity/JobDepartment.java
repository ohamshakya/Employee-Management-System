package com.project.ems.employeemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "job_department_details")
public class JobDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "department")
    private String department;

    @Column(name = "description")
    private String description;

    @Column(name = "salary_range")
    private Long salaryRange;

    @OneToMany(mappedBy = "jobDepartment", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Salary> salaryList;
}
