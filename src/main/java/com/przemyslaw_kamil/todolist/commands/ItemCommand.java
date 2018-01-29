package com.przemyslaw_kamil.todolist.commands;

import com.przemyslaw_kamil.todolist.domain.ColorProject;
import com.przemyslaw_kamil.todolist.domain.Details;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class ItemCommand {
    private Long id;
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    private Details details;
    private ColorProject colorProject;

    public ItemCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Details getDetails() {
        if (details == null) {
            details = new Details();
        }
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public ColorProject getColorProject() {
        return colorProject;
    }

    public void setColorProject(ColorProject colorProject) {
        this.colorProject = colorProject;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
