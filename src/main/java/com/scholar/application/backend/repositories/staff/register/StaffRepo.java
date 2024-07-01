package com.scholar.application.backend.repositories.staff.register;

import com.scholar.application.backend.entities.staff.register.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepo extends JpaRepository<Teacher, Long> {
    @Query("select c from Teacher c " +
            "where lower(c.surname) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.givenName) like lower(concat('%', :searchTerm, '%'))")
    List<Teacher> search(@Param("searchTerm") String searchTerm);
}
