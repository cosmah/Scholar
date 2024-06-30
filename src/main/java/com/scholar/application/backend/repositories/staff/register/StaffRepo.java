package com.scholar.application.backend.repositories.staff.register;

import com.scholar.application.backend.entities.staff.register.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRepo extends JpaRepository<Teacher, Long> {
    @Query("select t from Teacher t " +
            "where lower(t.surname) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(t.givenName) like lower(concat('%', :searchTerm, '%'))")
    List<Teacher> search(@Param("searchTerm") String searchTerm);
}
