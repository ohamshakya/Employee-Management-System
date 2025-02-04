package com.project.ems.employeemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "salary_details")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amount")
    private String amount;

    @Column(name = "annual")
    private String annual;

    @Column(name = "bonus")
    private String bonus;

    @ManyToOne
    @JoinColumn(name = "job_department_id")
    private JobDepartment jobDepartment;
}
