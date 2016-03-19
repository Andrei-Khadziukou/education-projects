package com.spring_28min.xml_config;

import org.springframework.stereotype.Component;

/**
 * The greeter to say hello world.
 *
 * @author Andrei Khadziukou.
 */
@Component
public class HelloWorldGreeter {

    public String greetWorld() {
        return "Hello, World!";
    }
}
