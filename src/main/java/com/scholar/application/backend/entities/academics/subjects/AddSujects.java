package com.scholar.application.backend.entities.academics.subjects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddSujects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private  String teachers;
    private String HOD;

    public AddSujects() {
    }

    public AddSujects(Long id, String subject, String teachers, String HOD) {
        this.id = id;
        this.subject = subject;
        this.teachers = teachers;
        this.HOD = HOD;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public String getHOD() {
        return HOD;
    }

    public void setHOD(String HOD) {
        this.HOD = HOD;
    }
}
