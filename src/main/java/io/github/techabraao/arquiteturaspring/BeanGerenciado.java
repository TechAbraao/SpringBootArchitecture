package io.github.techabraao.arquiteturaspring;

import io.github.techabraao.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Lazy
// Escopo padrão Singleton, ou seja, utilizando uma única instância do objeto gerenciado pelo Spring Context.
@Component
@Scope(
        BeanDefinition.SCOPE_SINGLETON
)
// Exemplo com escopo de sessão do usuário
// @Scope(WebApplicationContext.SCOPE_SESSION)
public class BeanGerenciado {

    @Autowired
    private TodoValidator validator;

    @Autowired
    private String variavel;

    @Autowired
    private Integer valor;

    // Pode ou não utilizar o @Autowired
    @Autowired
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }
}
