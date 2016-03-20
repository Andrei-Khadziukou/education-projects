package com.spring_28min.service;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

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
}
