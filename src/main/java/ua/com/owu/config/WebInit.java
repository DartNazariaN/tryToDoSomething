package ua.com.owu.config;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        ServletRegistration.Dynamic registration = servletContext
                .addServlet("dispatcherServlet", new DispatcherServlet(context));
        registration.addMapping("/");
        registration.setLoadOnStartup(1);
        MultipartConfigElement configElement = new MultipartConfigElement("", 10000000, 10000000, 10000000);
        registration.setMultipartConfig(configElement);
    }
}