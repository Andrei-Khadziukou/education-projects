package com.et.hello;

import javax.ejb.Stateless;

/**
 * Implementation {@link HelloWorldRemote} to say "Hello, World!" on English.
 * Date: 03/05/2016
 *
 * @author Andrei_Khadziukou
 */
@Stateless
public class EnglishHelloWorld implements HelloWorldRemote {
    @Override
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}
