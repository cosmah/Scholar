package com.scholar.application.backend.entities.students.classrooms;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ClassRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String classRoomName;
    private String classRoomStream;
    private String classTeacher;


    public ClassRooms() {
    }

    public ClassRooms(Long id, String classRoomName, String classRoomStream, String classTeacher) {
        this.id = id;
        this.classRoomName = classRoomName;
        this.classRoomStream = classRoomStream;
        this.classTeacher = classTeacher;
    }

    public Long getId() {
        return id;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public String getClassRoomStream(){
        return classRoomStream;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClassRoomName(String classRoomName){
        this.classRoomName = classRoomName;
    }

    public void setClassRoomStream(String classRoomStream){
        this.classRoomStream = classRoomStream;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    
    
}
