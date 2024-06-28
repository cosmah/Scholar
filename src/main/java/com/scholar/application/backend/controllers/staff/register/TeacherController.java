package com.scholar.application.backend.controllers.staff.register;

import com.scholar.application.backend.entities.staff.register.Teacher;
import com.scholar.application.backend.services.staff.register.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/new/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        Teacher savedTeacher = teacherService.saveTeacher(teacher);
        return ResponseEntity.ok(savedTeacher);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        List<Teacher> teachers = teacherService.findAllTeachers();
        return ResponseEntity.ok(teachers);
    }
}
