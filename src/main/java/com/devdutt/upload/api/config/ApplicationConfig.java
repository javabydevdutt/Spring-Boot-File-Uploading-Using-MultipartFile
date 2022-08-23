package com.devdutt.upload.api.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class ApplicationConfig {

    //Approach:-1 (Java 8- Lambda Expression)
    @Bean
    public ServletContextInitializer contextInitializer() {
        return (sc) -> sc.setInitParameter("uplLocation", "C:/SpringUploads");
    }//contextInitializer()

    //Approach:-2
    //@Bean
    public ServletContextInitializer createInitializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.setInitParameter("uplLocation", "C:/SpringUploads");
            }
        };
    }//createInitializer()

    //Approach:-3
    //@Bean
    public WebApplicationInitializer webApplicationInitializer() {
        return new WebApplicationInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.setInitParameter("uplLocation", "C:/SpringUploads");
            }
        };
    }//webApplicationInitializer()

}
