package com.scholar.application.backend.services.academics.subjects;

import com.scholar.application.backend.entities.academics.subjects.AddSujects;
import com.scholar.application.backend.repositories.academics.subjects.SubjectsRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectsRepo subjectsRepo;

    public SubjectService(SubjectsRepo subjectsRepo) {
        this.subjectsRepo = subjectsRepo;
    }

    @Transactional
    public AddSujects saveSubject(AddSujects addSujects) {
        return subjectsRepo.save(addSujects);
    }

    public List<AddSujects> findAllSubjects() {
        return subjectsRepo.findAll();
    }
}
