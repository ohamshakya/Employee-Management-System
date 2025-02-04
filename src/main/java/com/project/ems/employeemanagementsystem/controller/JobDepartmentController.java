package com.project.ems.employeemanagementsystem.controller;

import com.project.ems.employeemanagementsystem.common.utils.PaginationUtil;
import com.project.ems.employeemanagementsystem.common.utils.ResponseWrapper;
import com.project.ems.employeemanagementsystem.dto.JobDepartmentDto;
import com.project.ems.employeemanagementsystem.service.JobDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/job-department")
@Slf4j
public class JobDepartmentController {

    private JobDepartmentService jobDepartmentService;

    //for default pagination size , sort by and sort order
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final String SORT_BY = "ASC";
    public static final String SORT_ORDER = "updatedAt";

    public JobDepartmentController(JobDepartmentService jobDepartmentService) {
        this.jobDepartmentService = jobDepartmentService;
    }

    @PostMapping
    public ResponseWrapper<JobDepartmentDto> createJobDepartment(@RequestBody JobDepartmentDto jobDepartmentDto) {
        log.info("inside create job department : controller");
        JobDepartmentDto response = jobDepartmentService.saveJobDepartment(jobDepartmentDto);
        return new ResponseWrapper<>(response, "Job department created", HttpStatus.CREATED.value());
    }

    @PutMapping("{id}")
    public ResponseWrapper<JobDepartmentDto> updateJobDepartment(@RequestBody JobDepartmentDto jobDepartmentDto, @PathVariable Integer id) {
        log.info("inside update job department : controller");
        JobDepartmentDto response = jobDepartmentService.updateJobDepartment(jobDepartmentDto, id);
        return new ResponseWrapper<>(response, "Job department updated", HttpStatus.OK.value());
    }

    @GetMapping("{id}")
    public ResponseWrapper<JobDepartmentDto> getJobDepartmentById(@PathVariable Integer id) {
        log.info("inside getJobDepartment by id : controller");
        JobDepartmentDto jobDepartmentDto = jobDepartmentService.getJobDepartmentById(id);
        return new ResponseWrapper<>(jobDepartmentDto, "Job department found", HttpStatus.OK.value());
    }

    @GetMapping
    public ResponseWrapper<Object> getAllJobDepartments(@RequestParam("size") Optional<Integer> size,
                                                        @RequestParam("page") Optional<Integer> page,
                                                        @RequestParam("sortBy") Optional<String> sortBy,
                                                        @RequestParam("sortOrder") Optional<String> sortOrder) {
        log.info("inside getAllJobDepartment : controller");
        Pageable pageable = PaginationUtil.preparePaginationRequest(
                page,
                size.orElse(DEFAULT_PAGE_SIZE),
                sortBy.orElse(SORT_BY),
                sortOrder.orElse(SORT_ORDER)

        );
        Object response;
        if (page.isPresent()) {
            response = jobDepartmentService.getJobDepartments(pageable);
        } else {
            response = jobDepartmentService.getJobDepartments();
        }

        return new ResponseWrapper<>(response, "Job departments found", HttpStatus.OK.value());
    }

    @DeleteMapping("{id}")
    public ResponseWrapper<Object> deleteJobDepartmentById(@PathVariable Integer id) {
        log.info("inside deleteJobDepartment : controller");
        jobDepartmentService.deleteJobDepartment(id);
        return new ResponseWrapper<>(null, "Job department deleted", HttpStatus.NO_CONTENT.value());
    }
}
