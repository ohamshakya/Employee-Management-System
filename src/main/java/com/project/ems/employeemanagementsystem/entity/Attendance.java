package com.project.ems.employeemanagementsystem.entity;

import com.project.ems.employeemanagementsystem.common.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "attendance_details")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    private LocalDateTime date;

    private LocalTime timeIn;

    private LocalTime timeOut;

    private Status status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;



}
