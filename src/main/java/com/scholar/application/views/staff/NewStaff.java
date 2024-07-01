package com.scholar.application.views.staff;

import com.scholar.application.backend.entities.staff.register.Teacher;
import com.scholar.application.backend.services.staff.register.TeacherService;
import com.scholar.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Add Staff")
@Route(value = "enroll/new-staff", layout = MainLayout.class)
public class NewStaff extends FormLayout {

    private Teacher teacher;

    private TextField surname = new TextField("Surname");
    private TextField givenName = new TextField("Given Name");
    private TextField NIN = new TextField("NIN");
    private DatePicker dob = new DatePicker("DOB");
    private TextField contact1 = new TextField("Contact 1");
    private TextField contact2 = new TextField("Contact 2");
    private TextField role = new TextField("Role");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<Teacher> binder = new BeanValidationBinder<>(Teacher.class);

    public NewStaff(){
        addClassName("register-staff");
        binder.bindInstanceFields(this);
        add(
                surname,
                givenName,
                NIN,
                dob,
                contact1,
                contact2,
                role,
                createButtonsLayout()
        );
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);
        return new HorizontalLayout(save, delete, close);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, teacher)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));
        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));
        return new HorizontalLayout(save, delete, close);
    }
    private void validateAndSave() {
        try {
            binder.writeBean(teacher);
            fireEvent(new SaveEvent(this, teacher));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }


        private void clearFields(){
        surname.clear();
        givenName.clear();
        NIN.clear();
        dob.clear();
        contact1.clear();
        contact2.clear();
        role.clear();


    }

    public void setContact(Teacher teacher) {
        this.teacher = teacher;
        binder.readBean(teacher);
    }

    // Events
    public static abstract class NewStaffEvent extends ComponentEvent<NewStaff> {
        private Teacher teacher;
        protected NewStaffEvent(NewStaff source, Teacher teacher) {
            super(source, false);
            this.teacher = teacher;
        }
        public Teacher getTeacher() {
            return teacher;
        }
    }
    public static class SaveEvent extends NewStaffEvent {
        SaveEvent(NewStaff source, Teacher teacher) {
            super(source, teacher);
        }
    }
    public static class DeleteEvent extends NewStaffEvent {
        DeleteEvent(NewStaff source, Teacher teacher) {
            super(source, teacher);
        }
    }
    public static class CloseEvent extends NewStaffEvent {
        CloseEvent(NewStaff source) {
            super(source, null);
        }
    }
    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }




}
