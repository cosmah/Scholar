package com.scholar.application.backend.repositories.academics.subjects;

import com.scholar.application.backend.entities.academics.subjects.AddSujects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectsRepo extends JpaRepository<AddSujects, Long> {
}
