package com.scholar.application.backend.repositories.students.classroom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scholar.application.backend.entities.staff.register.Teacher;
import com.scholar.application.backend.entities.students.classrooms.ClassRooms;

import java.util.List;

@Repository
public interface ClassRoomRepo extends JpaRepository<ClassRooms, Long> {
    @Query("select c from ClassRoom c " +
            "where lower(c.classRoom) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.classRoomStream) like lower(concat('%', :searchTerm, '%'))")
    List<ClassRooms> search(@Param("searchTerm") String searchTerm);
}
