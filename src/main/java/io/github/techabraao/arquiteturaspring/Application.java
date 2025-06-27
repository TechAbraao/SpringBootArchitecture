package io.github.techabraao.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {
	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);

		// SpringApplicationBuilder inicializará o projeto também.
		SpringApplicationBuilder builder = new SpringApplicationBuilder(
				Application.class
		);

		builder.bannerMode(Banner.Mode.OFF);
		// Lazy vai significar que os objetos so serão instanciados no contexto do Spring quando forem utilizados pela aplicação.
	//	builder.lazyInitialization(true);
		builder.run(args);

		// ConfigurableApplicationContext é usado para configurar a instância em execução atual.
		ConfigurableApplicationContext applicationContext = builder.context();
		// var produtoRepository = applicationContext.getBean("produtoRepository");

		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment
				.getProperty("spring.application.name");

		ExemploValue variablesYml = applicationContext.getBean(ExemploValue.class);
		variablesYml.imprimirVariavel();

		AppConfigurations configurationsProperties = applicationContext.getBean(AppConfigurations.class);
		System.out.println("Valor: " + configurationsProperties.getValor());

		System.out.printf("Nome da Aplicação: %s%n", applicationName);
	}

}
