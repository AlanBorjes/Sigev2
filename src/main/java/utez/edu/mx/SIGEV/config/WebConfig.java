package utez.edu.mx.SIGEV.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    public void addResourceHandlers(ResourceHandlerRegistry handlerRegistry) {
        handlerRegistry.addResourceHandler("/docs/**").addResourceLocations("file:C:/comve/docs/");
    }
    
}
