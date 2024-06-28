package com.scholar.application.backend.repositories.staff.register;

import com.scholar.application.backend.entities.staff.register.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<Teacher, Long> {
}
