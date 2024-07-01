package com.scholar.application.views.staff;

import com.scholar.application.backend.entities.staff.register.Teacher;
import com.scholar.application.backend.services.staff.register.TeacherService;
import com.scholar.application.views.MainLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
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
        configureGrid();
        configureFilter();

        form = new NewStaff();
        Div content = new Div(grid, form);
        content.addClassName("content");
        content.setSizeFull();
        add(filterText, content);
        updateList();


    }

    private void configureFilter() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());
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
