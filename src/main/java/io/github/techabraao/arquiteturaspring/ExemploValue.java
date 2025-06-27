package io.github.techabraao.arquiteturaspring;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExemploValue {

    @Value("${app.config.variable}")
    private String variavel;


    public void imprimirVariavel(){
        System.out.println("Essa é a variável definida no Yml: " + variavel);
    }

}
