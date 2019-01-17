package com.autentia.todolist.model.entities;

import javax.persistence.*;

@Entity
public class Todo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, length = 1000)
    private String description;

    private boolean done;

    public Todo() {
    }

    public Todo(String description) {
        this.description = description;
        this.done = false;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Todo{");
        sb.append("id=").append(id);
        sb.append(", description='").append(description).append('\'');
        sb.append(", done=").append(done);
        sb.append('}');
        return sb.toString();
    }
}
