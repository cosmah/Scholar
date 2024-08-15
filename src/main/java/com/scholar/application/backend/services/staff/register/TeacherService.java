package com.scholar.application.backend.services.staff.register;

import com.scholar.application.backend.entities.staff.register.Teacher;
import com.scholar.application.backend.repositories.staff.register.StaffRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final StaffRepo staffRepo;

    public TeacherService(StaffRepo staffRepo){
        this.staffRepo = staffRepo;
    }


    @Transactional
    public Teacher save(Teacher teacher) {
        return staffRepo.save(teacher);
    }

    @Transactional
    public void delete(Teacher teacher) {
        staffRepo.delete(teacher);
    }


    public List<Teacher> findAllTeachers() {
        return staffRepo.findAll();
    }


    public List<Teacher> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return staffRepo.findAll();
        } else {
            return staffRepo.search(stringFilter);
        }
    }

}
