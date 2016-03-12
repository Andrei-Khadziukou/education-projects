package com.spring_28min.service;

import org.springframework.stereotype.Component;

/**
 * Good Morning service from the sample of the lecture 3.
 *
 * @author Andrei Khadziukou
 */
@Component
public class GoodMorningService implements HiService {

    @Override
    public String sayHi() {
        return "Good Morning!";
    }
}
