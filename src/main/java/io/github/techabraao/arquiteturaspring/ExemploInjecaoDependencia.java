package io.github.techabraao.arquiteturaspring;

import io.github.techabraao.arquiteturaspring.todos.TodoEntity;
import io.github.techabraao.arquiteturaspring.todos.TodoRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ExemploInjecaoDependencia {
    public static void main(String[] args) throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("URL");
        dataSource.setUsername("USER");
        dataSource.setPassword("PASSWORD");

        Connection connection = dataSource.getConnection();

        // ... Instanciar várias coisas pra ter o mesmo resultado.

       // TodoRepository repository = new SimpleJpaRepository<TodoEntity, Integer>();
    }
}
