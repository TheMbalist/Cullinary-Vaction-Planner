package com.example.cullinaryplanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("http://localhost:4200") // Allow requests from this origin (your Angular app)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify the allowed methods
                .allowedHeaders("*"); // Allow all headers
    }
    
}
