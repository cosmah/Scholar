package com.scholar.application.backend.services.students.enroll;

import com.scholar.application.backend.entities.students.enroll.EnrollmentEntity;
import com.scholar.application.backend.repositories.students.enroll.EnrollmentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    public final EnrollmentRepo enrollmentRepo;

    public EnrollmentService(EnrollmentRepo enrollmentRepo){
        this.enrollmentRepo = enrollmentRepo;
    }

    @Transactional
    public EnrollmentEntity saveStudent(EnrollmentEntity enrollment){
        return enrollmentRepo.save(enrollment);
    }

    public List<EnrollmentEntity> findAllStudents(){
        return enrollmentRepo.findAll();
    }
}
