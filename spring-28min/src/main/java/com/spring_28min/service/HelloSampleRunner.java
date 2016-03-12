package com.spring_28min.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired // inject dependency
    private GoodMorningService goodMorningService;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
        HelloSampleRunner runner = context.getBean(HelloSampleRunner.class);
        runner.say();
    }

    public void say() {
        System.out.println(goodMorningService.sayHi());
    }

}
