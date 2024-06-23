package com.scholar.application.views.dashboard;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.scholar.application.views.MainLayout;

import java.util.Arrays;
import java.util.List;

@PageTitle("Dashboard | Scholar Management System")
@Route(value = "dashboard", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class DashboardView extends Main {

    public DashboardView() {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();

        // Top stats section
        HorizontalLayout statsLayout = new HorizontalLayout();
        statsLayout.setWidthFull();

        Div studentCount = createStatsCard("Students", "150");
        Div courseCount = createStatsCard("Courses", "25");
        Div recentActivities = createStatsCard("Recent Activities", "5");

        statsLayout.add(studentCount, courseCount, recentActivities);

        // Recent activities section
        Grid<Activity> activityGrid = new Grid<>(Activity.class);
        activityGrid.setItems(getRecentActivities());

        layout.add(statsLayout, activityGrid);
        add(layout);
    }

    private Div createStatsCard(String title, String count) {
        Div card = new Div();
        card.addClassName("stats-card");
        card.setWidth("200px");

        Span titleSpan = new Span(title);
        titleSpan.addClassName("stats-title");

        Span countSpan = new Span(count);
        countSpan.addClassName("stats-count");

        card.add(titleSpan, countSpan);
        return card;
    }

    private List<Activity> getRecentActivities() {
        // This should fetch real data in a real application
        return Arrays.asList(
                new Activity("John Doe", "Enrolled in Math 101"),
                new Activity("Jane Smith", "Completed Chemistry 201"),
                new Activity("John Doe", "Enrolled in Physics 101"),
                new Activity("Mary Johnson", "Dropped Math 101"),
                new Activity("Peter Brown", "Enrolled in English 101")
        );
    }

    public static class Activity {
        private String student;
        private String action;

        public Activity(String student, String action) {
            this.student = student;
            this.action = action;
        }

        public String getStudent() {
            return student;
        }

        public void setStudent(String student) {
            this.student = student;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }
}
