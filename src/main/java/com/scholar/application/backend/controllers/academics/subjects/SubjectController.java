package com.scholar.application.backend.controllers.academics.subjects;

import com.scholar.application.backend.entities.academics.subjects.AddSujects;
import com.scholar.application.backend.services.academics.subjects.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/new/subject")
public class SubjectController {
    public final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @PostMapping
    public ResponseEntity<AddSujects> createSubject(@RequestBody AddSujects addSujects){
        AddSujects savedSubjects = subjectService.saveSubject(addSujects);
        return ResponseEntity.ok(savedSubjects);
    }

//    @GetMapping
//    public ResponseEntity<List<AddSujects>> getAllSubjects{
//        List<AddSujects> sujects = subjectService.findAllSubjects();
//        return ResponseEntity.ok(sujects);
//    }


}
