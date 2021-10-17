package com.project.apt;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    //    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//
//        registry
//                .addInterceptor(new LoginCheckIntercepter())
//                .addPathPatterns("/api/**")
//                .excludePathPatterns("/css/**", "/*.co","/**","/api/**");
//    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:8080", "http://localhost:8081");
    }

}
