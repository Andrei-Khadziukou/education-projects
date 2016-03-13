package com.spring_28min.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * The runner to show how the example from the lecture 3 works.
 *
 * Date: 08.03.2016.
 * @author Andrei Khadziukou
 */
@Component // note that spring must create it and initialize
public class HelloSampleRunner {

    // the Spring tries to find suitable bean with the same class or which implements specified interface
    /*
    If there are two implementation of the service spring analyze
        1. the name of variable and tries to find bean with similar name
        2. the value specified in @Qualifier and tries to find bean with similar name
     */
    @Autowired // inject dependency
    @Qualifier("goodEveningService") // you can use hiService instead of goodEventService below
    private HiService goodEveningService;

    public static void main(String[] args) {
        // creating spring (spring context) for usage and specify configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
        HelloSampleRunner runner = context.getBean(HelloSampleRunner.class);
        runner.say();
    }

    public void say() {
        System.out.println(goodEveningService.sayHi());
    }

}
