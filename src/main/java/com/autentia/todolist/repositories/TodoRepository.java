package com.autentia.todolist.repositories;

import com.autentia.todolist.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> findByDone(boolean done);
}
