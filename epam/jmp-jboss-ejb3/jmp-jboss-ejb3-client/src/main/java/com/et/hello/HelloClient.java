package com.et.hello;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Base interface to say "Hello world".
 * Date: 03/05/2016
 *
 * @author Andrei_Khadziukou
 */
public class HelloClient {
/*
java:global/jmp-jboss-ejb3-impl-1.0-SNAPSHOT/EnglishHelloWorld!com.et.hello.HelloWorldRemote
        java:app/jmp-jboss-ejb3-impl-1.0-SNAPSHOT/EnglishHelloWorld!com.et.hello.HelloWorldRemote
        java:module/EnglishHelloWorld!com.et.hello.HelloWorldRemote
        java:jboss/exported/jmp-jboss-ejb3-impl-1.0-SNAPSHOT/EnglishHelloWorld!com.et.hello.HelloWorldRemote
        java:global/jmp-jboss-ejb3-impl-1.0-SNAPSHOT/EnglishHelloWorld
        java:app/jmp-jboss-ejb3-impl-1.0-SNAPSHOT/EnglishHelloWorld
        java:module/EnglishHelloWorld
 */

    public static void main(String[] args) throws NamingException {
        HelloWorldRemote helloWorldRemote = (HelloWorldRemote) getContext()
            .lookup("jmp-jboss-ejb3-impl-1.0-SNAPSHOT/EnglishHelloWorld!com.et.hello.HelloWorldRemote");
        System.out.println("Test");
        helloWorldRemote.sayHello();
        System.out.println("End");
    }

    private static Context getContext() throws NamingException {
        Hashtable<String, Object> p = new Hashtable<String, Object>();
        p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        p.put("jboss.naming.client.ejb.context", true);
        p.put(Context.PROVIDER_URL, "remote://127.0.0.1:4447/");
//        p.put(InitialContext.SECURITY_PRINCIPAL, "ivan10");
//        p.put(InitialContext.SECURITY_CREDENTIALS, "ivan123");
        p.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false");
        final Context context = new InitialContext(p);
        return context;
    }
}
