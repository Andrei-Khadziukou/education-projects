package com.et.greeter;

/**
 * The simple interface which provides ability to generate greet message people on different languages.
 * Date: 03/05/2016
 *
 * @author Andrei_Khadziukou
 */
public interface Greeter {

    /**
     * Generates a greet message for a person using provided name.
     *
     * @param name the name to greet
     * @return the generated message
     */
    String generateGreetMessage(String name);
}
