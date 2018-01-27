package com.przemyslaw_kamil.todolist.domain;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private LocalDate deadline;

    @OneToOne(cascade = CascadeType.ALL)
    private Details details;

    @Enumerated(value = EnumType.STRING)
    private ColorProject colorProject;


    public void setDetails(Details details) {
        if (details != null) {
            this.details = details;
            details.setItem(this);
        }
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Details getDetails() {
        return details;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setColorProject(ColorProject colorProject) {
        this.colorProject = colorProject;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public ColorProject getColorProject() {
        return colorProject;
    }

    public void setProject(String color) {
        this.colorProject = ColorProject.valueOf(color);
    }

}
