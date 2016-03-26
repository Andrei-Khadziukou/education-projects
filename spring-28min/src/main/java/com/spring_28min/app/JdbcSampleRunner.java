package com.spring_28min.app;

import com.spring_28min.domain.Todo;
import com.spring_28min.service.ApplicationContextConfiguration;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * The sample to show using the Spring JDBC.
 *
 * @author Andrei Khadziukou
 */
@Component
public class JdbcSampleRunner {

    private static Server DB_SERVER;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) throws SQLException {
        startDbServer();
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
        applicationContext.getBean(JdbcSampleRunner.class).runSample();
        stopDbServer();
    }

    public void runSample() {
        // create tables
        jdbcTemplate.execute("DROP TABLE todos");
        jdbcTemplate.execute("CREATE TABLE todos (id INTEGER NOT NULL UNIQUE, description CHARACTER(512), done BOOLEAN)");
        // insert data
        Todo todo = new Todo();
        todo.setId(1);
        todo.setDescription("Test description");
        todo.setDone(false);
        jdbcTemplate.update("INSERT INTO todos (id, description, done) VALUES (?, ?, ?)",
                todo.getId(), todo.getDescription(), todo.isDone());
        // read data
        Todo dbTodo = jdbcTemplate.queryForObject("SELECT id, description, done FROM todos WHERE id = ?",
                new Object[]{1}, new RowMapper<Todo>() {
            @Override
            public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
                Todo todo = new Todo();
                todo.setId(rs.getInt(1));
                todo.setDescription(rs.getString(2));
                todo.setDone(rs.getBoolean(3));
                return todo;
            }
        });
        System.out.println(dbTodo);

        // update data and read to show
        jdbcTemplate.update("UPDATE todos SET done = true WHERE id = ?", todo.getId());
        dbTodo = jdbcTemplate.queryForObject("SELECT id, description, done FROM todos WHERE id = ?", new Object[]{1},
                new BeanPropertyRowMapper<>(Todo.class));
        System.out.println(dbTodo);

        // read list
        List<Todo> todos = jdbcTemplate.query("SELECT id, description, done FROM todos",
                new BeanPropertyRowMapper<>(Todo.class));
        System.out.println(todos);

        // remove date
        jdbcTemplate.update("DELETE FROM todos WHERE id = ?", todo.getId());
        todos = jdbcTemplate.query("SELECT id, description, done FROM todos", new BeanPropertyRowMapper<>(Todo.class));
        System.out.println(todos);
    }

    public static void stopDbServer() throws SQLException {
        DB_SERVER.stop();
    }

    public static void startDbServer() throws SQLException {
        DB_SERVER = Server.createTcpServer().start();
    }
}
