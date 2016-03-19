package com.spring_28min.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * The modification of the sample from the lecture 3 to create spring context.
 *
 * @author Andrei Khadziukou
 */
@Configuration // from http://projects.spring.io/spring-framework/
// where to look for beans
@ComponentScan({"com.spring_28min.service", "com.spring_28min.app"}) // from http://projects.spring.io/spring-framework/
@ImportResource("/com/spring_28min/spring-config.xml") // add xml configuration to the java configuration
public class ApplicationContextConfiguration {
}
