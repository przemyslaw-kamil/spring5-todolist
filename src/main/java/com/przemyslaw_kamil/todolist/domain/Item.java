package com.przemyslaw_kamil.todolist.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    @OneToOne(cascade = CascadeType.ALL)
    private Details details;

    @Enumerated(value = EnumType.STRING)
    private ColorProject colorProject;

    public Item() {
        this.colorProject = ColorProject.none;
    }

    public void setDetails(Details details) {
        if (details != null) {
            this.details = details;
            details.setItem(this);
        }
    }

    public Details getDetails() {
        if (details == null) {
            this.details = new Details();
            details.setItem(this);
        }
        return details;
    }


    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColorProject(ColorProject colorProject) {
        this.colorProject = colorProject;
    }

    public ColorProject getColorProject() {
        return colorProject;
    }

    public void setProject(String color) {
        this.colorProject = ColorProject.valueOf(color);
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

}
