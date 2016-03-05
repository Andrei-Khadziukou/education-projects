package com.et.hello;

import javax.ejb.Remote;

/**
 * Base interface to say "Hello world".
 * Date: 03/05/2016
 *
 * @author Andrei_Khadziukou
 */
@Remote
public interface HelloWorldRemote {

    /**
     * Prints hello world message to console.
     */
    void sayHello();
}
