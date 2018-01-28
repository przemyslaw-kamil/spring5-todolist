package com.przemyslaw_kamil.todolist.commands;

import com.przemyslaw_kamil.todolist.domain.ColorProject;
import com.przemyslaw_kamil.todolist.domain.Details;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class ItemCommand {
    private Long id;
    private String description;
    private LocalDate deadline;
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
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

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Details getDetails() {
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
}
