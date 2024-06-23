package com.scholar.application.backend.repositories.students.enroll;

import com.scholar.application.backend.entities.students.enroll.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<EnrollmentEntity, Long> {
}
