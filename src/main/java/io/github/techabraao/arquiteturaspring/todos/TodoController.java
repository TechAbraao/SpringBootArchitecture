package io.github.techabraao.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/todos")
public class TodoController {

    // O Serviço do Todo
    private TodoService service;

    // Injeção de dependência através do construtor
    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo) {
        try {
            return this.service.salvar(todo);
        } catch (IllegalArgumentException e) {
            String mensagemErro = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarTodo(@PathVariable("id") Integer id, @RequestBody TodoEntity todo) {
        todo.setId(id);
        service.atualizarStatus(todo);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "atualizado com sucesso"));

    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Integer id) {
        TodoEntity todo = service.buscarPorID(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", todo));
    }

}
