package io.github.techabraao.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);

		// SpringApplicationBuilder inicializará o projeto também.
		SpringApplicationBuilder builder = new SpringApplicationBuilder(
				Application.class
		);

		builder.bannerMode(Banner.Mode.OFF);
		builder.run(args);

		// ConfigurableApplicationContext é usado para configurar a instância em execução atual.
		ConfigurableApplicationContext applicationContext = builder.context();
		// var produtoRepository = applicationContext.getBean("produtoRepository");

		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment
				.getProperty("spring.application.name");

		System.out.printf("Nome da Aplicação: %s%n", applicationName);
	}

}
