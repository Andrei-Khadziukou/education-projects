package com.spring_28min.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * The modification of the sample from the lecture 3 to create spring context.
 *
 * @author Andrei Khadziukou
 */
@Configuration // from http://projects.spring.io/spring-framework/
// where to look for beans
@EnableAspectJAutoProxy // not sure it was mentioned in a lesson 12-13
@ComponentScan({"com.spring_28min.service", "com.spring_28min.app",
        "com.spring_28min.aop"}) // from http://projects.spring.io/spring-framework/
@ImportResource("/com/spring_28min/spring-config.xml") // add xml configuration to the java configuration
public class ApplicationContextConfiguration {

    /*
    The configuration which is necessary when we need to interact with database
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
}
