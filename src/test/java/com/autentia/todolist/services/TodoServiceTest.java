package com.autentia.todolist.services;

import com.autentia.todolist.model.Todo;
import com.autentia.todolist.repositories.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    public void showOnlyPendingsTodosTest() {

        boolean showOnlyPendings = true;

        when(todoRepository.findByDone(false)).thenReturn(new ArrayList<>());

        todoService.list(showOnlyPendings);

        verify(todoRepository, times(1)).findByDone(false);
        verify(todoRepository, never()).findAll();
    }

    @Test
    public void onlyDonesTodosAreReturned() {

        boolean showOnlyPendings = true;

        List<Todo> todosExpected = new ArrayList<>();
        todosExpected.add(mock(Todo.class));
        todosExpected.add(mock(Todo.class));

        when(todoRepository.findByDone(false)).thenReturn(todosExpected);

        List<Todo> todos = todoService.list(showOnlyPendings);

        assertThat(todos, is(todosExpected));
    }

    @Test
    public void showAllTodosTest() {

        boolean showOnlyPendings = false;

        when(todoRepository.findAll()).thenReturn(new ArrayList<>());

        todoService.list(showOnlyPendings);

        verify(todoRepository, never()).findByDone(false);
        verify(todoRepository, times(1)).findAll();
    }

    @Test
    public void allTodosAreReturned() {

        boolean showOnlyPendings = false;

        List<Todo> todosExpected = new ArrayList<>();
        todosExpected.add(mock(Todo.class));
        todosExpected.add(mock(Todo.class));

        when(todoRepository.findAll()).thenReturn(todosExpected);

        List<Todo> todos = todoService.list(showOnlyPendings);

        assertThat(todos, is(todosExpected));
    }
}
