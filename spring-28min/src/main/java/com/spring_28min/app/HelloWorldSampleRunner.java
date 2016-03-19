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

    @Autowired
    private HelloWorldGreeter helloWorldGreeter;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
        HelloWorldSampleRunner runner = context.getBean(HelloWorldSampleRunner.class);
        runner.runSample();
    }

    public void runSample() {
        System.out.println(helloWorldGreeter.greetWorld());
    }
}
