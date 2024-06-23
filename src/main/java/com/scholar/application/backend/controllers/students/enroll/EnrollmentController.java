package com.scholar.application.backend.controllers.students.enroll;

import com.scholar.application.backend.entities.students.enroll.EnrollmentEntity;
import com.scholar.application.backend.services.students.enroll.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/new/student")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService){
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<EnrollmentEntity> createEnrollement(@RequestBody EnrollmentEntity enrollment){
        EnrollmentEntity savedStudents = enrollmentService.saveStudent(enrollment);
        return ResponseEntity.ok(savedStudents);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentEntity>> getAllStudents(){
        List<EnrollmentEntity> students = enrollmentService.findAllStudents();
        return ResponseEntity.ok(students);
    }
}
