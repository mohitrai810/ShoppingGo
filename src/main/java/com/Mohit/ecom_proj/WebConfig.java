package com.Mohit.ecom_proj;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow all paths
                .allowedOrigins("http://localhost:5173")  // Allow frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow common HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);
    }
}
