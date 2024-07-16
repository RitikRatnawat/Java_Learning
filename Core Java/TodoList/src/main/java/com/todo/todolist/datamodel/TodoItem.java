package com.todo.todolist.datamodel;

import java.time.LocalDate;

public class TodoItem
{
    private String shortDescription;
    private String longDescription;
    private LocalDate deadline;

    public TodoItem(String shortDescription, String longDescription, LocalDate deadline)
    {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.deadline = deadline;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
