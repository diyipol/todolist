package com.autentia.todolist.controllers;

import com.autentia.todolist.model.Todo;
import com.autentia.todolist.services.TodoService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "Operaciones para visualizar, crear y modificar notas.")
@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @ApiOperation("Devuelve una lista con las notas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Listado de notas devueltas correctamente")
    })
    @GetMapping("/todos")
    public List<Todo> list(@ApiParam("Indica si sólo se quieren mostrar las notas no marcadas como finalizadas") @RequestParam boolean showOnlyPendings) {
        return todoService.list(showOnlyPendings);
    }
}
