package com.spring_28min.service;

import org.springframework.stereotype.Component;

/**
 * Good Evening service from the sample of the lecture 7. It helps to demonstrate the spring can resolve autowiring
 * issues by using bean names. By default, the spring uses the class name to generate bean name.
 *
 * @author Andrei Khadziukou
 */
@Component
public class GoodEveningService implements HiService {

    @Override
    public String sayHi() {
        return "Good Evening!";
    }
}
