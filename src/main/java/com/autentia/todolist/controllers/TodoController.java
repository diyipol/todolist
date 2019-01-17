package com.autentia.todolist.controllers;

import com.autentia.todolist.model.Todo;
import com.autentia.todolist.services.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> list(@RequestParam boolean showOnlyPendings) {
        return todoService.list(showOnlyPendings);
    }
}
