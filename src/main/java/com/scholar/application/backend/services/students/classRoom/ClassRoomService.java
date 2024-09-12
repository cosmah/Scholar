package com.scholar.application.backend.services.students.classRoom;

import org.springframework.stereotype.Service;

import com.scholar.application.backend.entities.staff.register.Teacher;
import com.scholar.application.backend.entities.students.classrooms.ClassRooms;
import com.scholar.application.backend.repositories.staff.register.StaffRepo;
import com.scholar.application.backend.repositories.students.classroom.ClassRoomRepo;
import java.util.List;
import jakarta.transaction.Transactional;

@Service
public class ClassRoomService {
    private final ClassRoomRepo classRoomRepo;

    public ClassRoomService(ClassRoomRepo classRoomRepo){
        this.classRoomRepo = classRoomRepo;
    }


    @Transactional
    public ClassRooms save(ClassRooms classRooms) {
        return classRoomRepo.save(classRoomRepo);
    }

    @Transactional
    public void delete(ClassRooms classRooms) {
        classRoomRepo.delete(classRooms);
    }


    public List<ClassRooms> findAllClassRooms() {
        return classRoomRepo.findAll();
    }

    public List<ClassRooms> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return classRoomRepo.findAll();
        } else {
            return classRoomRepo.search(stringFilter);
        }
    }
    
}
