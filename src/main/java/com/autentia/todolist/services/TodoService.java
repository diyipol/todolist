package com.autentia.todolist.services;

import com.autentia.todolist.model.dtos.CreateTodoCommand;
import com.autentia.todolist.model.entities.Todo;
import com.autentia.todolist.repositories.TodoRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> list(boolean showOnlyPendings) {

        if (showOnlyPendings) {
            return todoRepository.findByDone(false);
        }

        return IterableUtils.toList(todoRepository.findAll());
    }

    public Todo create(CreateTodoCommand command) {

        Todo todo = new Todo(command.getDescription());

        todoRepository.save(todo);

        return todo;
    }
}
