package com.scholar.application.backend.controllers.students.classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scholar.application.backend.entities.students.classrooms.ClassRooms;
import com.scholar.application.backend.services.students.classRoom.ClassRoomService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@RestController
@RequestMapping("/new/classroom")
public class ClassRoomController {
    private final ClassRoomService classRoomService;
    
    @Autowired
    public ClassRoomController(ClassRoomService classRoomService){
        this.classRoomService = classRoomService;
    }

    @PostMapping
    public ResponseEntity<ClassRooms> createClassRoom(@RequestBody ClassRooms classRooms){
        ClassRooms savedClassRoom = classRoomService.save(classRooms);
        return ResponseEntity.ok(savedClassRoom);
    }

    @GetMapping
    public ResponseEntity<ClassRooms> getAllClassRooms(){
        List<ClassRooms> classRooms = classRoomService.findAllClassRooms();
        return ResponseEntity.ok(classRooms);
    }
    
    
}
