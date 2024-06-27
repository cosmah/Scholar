package com.scholar.application.views.academics.subjects;


import com.scholar.application.backend.entities.academics.subjects.AddSujects;
import com.scholar.application.backend.entities.students.enroll.EnrollmentEntity;
import com.scholar.application.backend.services.academics.subjects.SubjectService;
import com.scholar.application.views.MainLayout;
import com.scholar.application.views.students.Enroll;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

@PageTitle("Add Subject")
@Route(value = "add/subject", layout = MainLayout.class)
public class AddSubjects extends VerticalLayout {

    private final SubjectService subjectService;
    private static final Logger logger = Logger.getLogger(Enroll.class.getName());


    private TextField subject;
    private  TextField teacher;
    private TextField hod;

    @Autowired
    public AddSubjects(SubjectService subjectService){
        this.subjectService = subjectService;

        FormLayout form = new FormLayout();
        subject = new TextField("Subject");
        teacher = new TextField("Teacher");
        hod = new TextField("Head of Dept");

        Button subbutton = new Button("Add Subject", event -> {
            try{
                logger.info("Adding a subject.....");
                AddSujects addSujects = new AddSujects(
                        null,
                        subject.getValue(),
                        teacher.getValue(),
                        hod.getValue()
                );
                logger.info("Subject entity created: " + addSujects.toString());
                AddSujects savedSubject = subjectService.saveSubject(addSujects);
                logger.info("Subject added successfully: " + savedSubject.toString());
                Notification.show("Subject added successfully!", 1000, Notification.Position.MIDDLE);
                clearFields();
            } catch (Exception e) {
                logger.severe("Failed to add subject please try again: " + e.getMessage());
                Notification.show("Failed to add subject: " + e.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });

        form.add(
                subject, teacher,hod, subbutton
        );
        add(form);

    }

    private void clearFields(){
        subject.clear();
        teacher.clear();
        hod.clear();
    }
}
