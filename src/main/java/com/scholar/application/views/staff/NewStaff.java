package com.scholar.application.views.staff;

import com.scholar.application.backend.entities.staff.register.Teacher;
import com.scholar.application.backend.services.staff.register.TeacherService;
import com.scholar.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Add Staff")
@Route(value = "enroll/new-staff", layout = MainLayout.class)
public class NewStaff extends VerticalLayout {

    private final TeacherService teacherService;

    private Grid<Teacher> grid = new Grid<>(Teacher.class);
    private Binder<Teacher> binder = new Binder<>(Teacher.class);

    private TextField surname = new TextField("Surname");
    private TextField givenName = new TextField("Given Name");
    private TextField NIN = new TextField("NIN");
    private TextField dob = new TextField("DOB");
    private TextField contact1 = new TextField("Contact 1");
    private TextField contact2 = new TextField("Contact 2");
    private TextField role = new TextField("Role");
    private Button saveButton = new Button("Save");

    @Autowired
    public NewStaff(TeacherService teacherService) {
        this.teacherService = teacherService;

        add(surname, givenName, NIN, dob, contact1, contact2, role, saveButton, grid);
        configureGrid();
        configureBinder();

        saveButton.addClickListener(e -> saveTeacher());
    }

    @PostConstruct
    private void init() {
        updateGrid();
    }

    private void configureGrid() {
        grid.setColumns("surname", "givenName", "NIN", "DOB", "contact1", "contact2", "role");
    }

    private void configureBinder() {
        binder.bindInstanceFields(this);
    }

    private void saveTeacher() {
        Teacher teacher = new Teacher();
        if (binder.writeBeanIfValid(teacher)) {
            teacherService.saveTeacher(teacher);
            Notification.show("Teacher saved");
            updateGrid();
        } else {
            Notification.show("Please fill out all fields correctly.");
        }
    }

    private void updateGrid() {
        grid.setItems(teacherService.findAllTeachers());
    }
}
