package com.et.hello.greeter;

import com.et.greeter.Greeter;

/**
 * English greeter.
 * Date: 03/05/2016
 *
 * @author Andrei_Khadziukou
 */
public class EnglishGreeter implements Greeter {
    @Override
    public String generateGreetMessage(String name) {
        return "Hello + " + name + "!";
    }
}
