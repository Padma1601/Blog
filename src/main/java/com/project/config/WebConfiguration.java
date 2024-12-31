package com.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Value("${upload.path}") // Inject the upload path from application.properties
    private String uploadPath;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Allow requests from React dev server
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed HTTP methods
                .allowedHeaders("*"); // Allow all headers
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Map /images/** URL to the upload path
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:" + uploadPath + "/"); // Uses the value from application.properties
    }
}
