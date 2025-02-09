package com.project.ems.employeemanagementsystem.mapper;

import com.project.ems.employeemanagementsystem.dto.LeaveDto;
import com.project.ems.employeemanagementsystem.entity.Leave;

public class LeaveMapper {
    public static Leave toEntity(LeaveDto leaveDto){
        Leave leave = new Leave();
        leave.setId(leaveDto.getId());
        leave.setDate(leaveDto.getDate());
        leave.setReason(leaveDto.getReason());
        // todo
        return leave;
    }
}
