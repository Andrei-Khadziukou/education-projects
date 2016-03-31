package com.spring_28min.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.oxm.castor.CastorMarshaller;

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

    /*
    The configuration which is necessary when we need to configure Spring OMX
     */
    @Bean
    public CastorMarshaller createCastorMarshaller() {
        CastorMarshaller castorMarshaller = new CastorMarshaller();

        castorMarshaller.setMappingLocation(new ClassPathResource("com/spring_28min/castor-mapping.xml"));
        return castorMarshaller;
    }
}
