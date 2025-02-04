package com.project.ems.employeemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "qualification_details")
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "position")
    private String position;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "date_in")
    private LocalDateTime dateIn;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
