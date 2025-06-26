package io.github.techabraao.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

import java.util.Optional;

// Indica o esteriótipo de Serviços
@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(
            TodoRepository repository,
            TodoValidator validator,
            MailSender mailSender
    ) {
        this.repository = repository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo) {
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluído." : "Não concluído.";
        mailSender.enviar("Todo " + todo.getDescricao() + " foi att para " + status);
    }
    
    public TodoEntity buscarPorID(Integer id) {
        return repository.findById(id).orElse(null);
    }
    

}
