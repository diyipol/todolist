package com.autentia.todolist.model.dtos;

public class CreateTodoCommand {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateTodoCommand{");
        sb.append("description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
