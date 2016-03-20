package com.spring_28min.app;

import com.spring_28min.service.ApplicationContextConfiguration;
import com.spring_28min.service.FarewellService;
import com.spring_28min.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * The runner to show sample about AOP.
 *
 * @author Andrei Khadziukou
 */
@Component
public class AopSampleRunner {

    @Autowired
    private HiService goodMorningService;

    @Autowired
    private FarewellService farewellService;

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
        AopSampleRunner aopSampleRunner = applicationContext.getBean(AopSampleRunner.class);
        aopSampleRunner.runSample();
    }

    public void runSample() {
        System.out.println(goodMorningService.sayHi());
        System.out.println("Doing something!!!");
        System.out.println(farewellService.farewell());
    }
}
