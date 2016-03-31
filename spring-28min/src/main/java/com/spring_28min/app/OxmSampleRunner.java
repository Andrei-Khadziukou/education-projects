package com.spring_28min.app;

import com.spring_28min.domain.Todo;
import com.spring_28min.service.ApplicationContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.stereotype.Component;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;

/**
 * The runner to show the sample of using the Spring OXM and the Castor library.
 *
 * @author Andrei Khadziukou
 */
@Component
public class OxmSampleRunner {

    private static final String XML_TODO = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<todo done=\"false\" id=\"1\"><description>Complete Spring Training!!!</description></todo>";

    @Autowired
    private CastorMarshaller marshaller;

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
        OxmSampleRunner oxmSampleRunner = applicationContext.getBean(OxmSampleRunner.class);
        oxmSampleRunner.runSample();
    }

    public void runSample() throws IOException {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setDone(false);
        todo.setDescription("Complete Spring Training!!!");

        marshaller.marshal(todo, new StreamResult(System.out));

        System.out.println();
        Todo xmlTodo = (Todo) marshaller.unmarshal(new StreamSource(new StringReader(XML_TODO)));
        System.out.println(xmlTodo);
    }
}
