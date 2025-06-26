package io.github.techabraao.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {
    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    // Validadores no SpringBoot
    public void validar(TodoEntity todo) {
        if (existeTodoComEssaDescricao(todo.getDescricao())) {
            throw new IllegalArgumentException("Já existe um TODO com essa descrição");
        }
    }
    private boolean existeTodoComEssaDescricao(String descricao) {
        return repository.existsByDescricao(descricao);
    }

}
