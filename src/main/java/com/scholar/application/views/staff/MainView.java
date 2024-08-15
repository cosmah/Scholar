package com.scholar.application.views.staff;

import com.scholar.application.backend.entities.staff.register.Teacher;
import com.scholar.application.backend.services.staff.register.TeacherService;
import com.scholar.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Our Staff")
@Route(value = "enroll/staff", layout = MainLayout.class)
@CssImport("./styles/shared-styles.css")
public class MainView extends VerticalLayout {

    private Grid<Teacher> grid = new Grid<>(Teacher.class);
    private TeacherService teacherService;
    private TextField filterText = new TextField();
    private NewStaff form;

    public MainView(TeacherService teacherService) {
        this.teacherService = teacherService;
        addClassName("list-view");
        setSizeFull();
        configureGrid(); // Configure the grid
        form = new NewStaff(); // Initialize the form

        // Add listeners for the form events
        form.addListener(NewStaff.SaveEvent.class, this::saveTeacher);
        form.addListener(NewStaff.DeleteEvent.class, this::deleteTeacher);
        form.addListener(NewStaff.CloseEvent.class, e -> closeEditor());

        Div content = new Div(grid, form);
        content.addClassName("content");
        content.setSizeFull();

        // Add the toolbar and content to the main layout
        add(getToolbar(), content);
        updateList(); // Update the list of teachers

        closeEditor(); // Close the editor initially
    }


    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        // Create the "Add Contact" button
        Button addTeacherButton = new Button("Add Teacher");
        addTeacherButton.addClickListener(click -> addTeacher()); // Call the addTeacher method when clicked

        // Create a HorizontalLayout to wrap the filter text field and the button
        HorizontalLayout toolbar = new HorizontalLayout(filterText, addTeacherButton);
        toolbar.addClassName("toolbar");
        return toolbar; // Return the toolbar layout
    }

    private void addTeacher() {
        grid.asSingleSelect().clear(); // Clear any selected item in the grid
        editTeacher(new Teacher()); // Open the editor for a new Teacher object
    }



    private void saveTeacher(NewStaff.SaveEvent event) {
        teacherService.save(event.getTeacher()); // Updated method call
        updateList();
        closeEditor();
    }

    private void deleteTeacher(NewStaff.DeleteEvent event) {
        teacherService.delete(event.getTeacher());
        updateList();
        closeEditor();
    }


    public void editTeacher(Teacher teacher) {
        if (teacher == null) {
            closeEditor();
        } else {
            form.setContact(teacher);
            form.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        form.setContact(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private void configureGrid() {
        grid.addClassName("staff-grid");
        grid.setSizeFull();
        grid.setColumns("surname", "givenName", "NIN", "DOB", "contact1", "contact2", "role");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateList() {
        grid.setItems(teacherService.findAll(filterText.getValue()));
    }
}
