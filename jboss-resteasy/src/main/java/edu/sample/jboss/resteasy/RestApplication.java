package edu.sample.jboss.resteasy;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * The Web service application to run scan for web services in application, see
 * http://buraktas.com/resteasy-example-without-using-a-web-xml/
 * Be sure you enable web services support in JBoss AS (<extension module="org.jboss.as.webservices"/>), see
 * http://www.mastertheboss.com/jboss-frameworks/resteasy/restful-web-services-on-jboss-as-7
 * See good example on https://examples.javacodegeeks.com/enterprise-java/rest/resteasy/resteasy-hello-world-example/
 * Date: 03/09/2016
 *
 * @author Andrei_Khadziukou
 */
@ApplicationPath("rest")
public class RestApplication extends Application {

}
