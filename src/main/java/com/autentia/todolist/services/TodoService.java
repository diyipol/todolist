package com.autentia.todolist.services;

import com.autentia.todolist.model.Todo;
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

    public List<Todo> list(boolean showOnlyDones) {

        if (showOnlyDones) {
            return todoRepository.findByDone(showOnlyDones);
        }

        return IterableUtils.toList(todoRepository.findAll());
    }
}