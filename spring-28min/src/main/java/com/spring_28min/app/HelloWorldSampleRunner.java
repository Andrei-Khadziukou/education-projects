package com.spring_28min.app;

import com.spring_28min.service.ApplicationContextConfiguration;
import com.spring_28min.xml_config.HelloWorldGreeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * The runner to show sample with xml and java spring context configuration.
 *
 * @author Andrei Khadziukou
 */
@Component
public class HelloWorldSampleRunner {

    private HelloWorldGreeter helloWorldGreeter;

    // spring prefer this over setter autowiring
    @Autowired // the sample of constructor autowiring (injecting dependency via constructor)
    public HelloWorldSampleRunner(HelloWorldGreeter helloWorldGreeter) {
        this.helloWorldGreeter = helloWorldGreeter;
    }

    public HelloWorldSampleRunner() {
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
        HelloWorldSampleRunner runner = context.getBean(HelloWorldSampleRunner.class);
        runner.runSample();
    }

    @Autowired // the sample of setter autowiring (injecting dependency via setter method)
    public void setHelloWorldGreeter(HelloWorldGreeter helloWorldGreeter) {
        this.helloWorldGreeter = helloWorldGreeter;
    }

    public void runSample() {
        System.out.println(helloWorldGreeter.greetWorld());
    }
}
