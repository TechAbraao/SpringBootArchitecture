package io.github.techabraao.arquiteturaspring;

import io.github.techabraao.arquiteturaspring.todos.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class ConfiguracaoAcessoEmail {

    @Autowired
    private AppConfigurations properties;

    @Bean
    public MailSender mailSender() {
        return null;
    }
}
