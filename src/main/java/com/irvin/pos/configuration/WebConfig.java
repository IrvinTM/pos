package com.irvin.pos.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry){
            registry.addMapping("/**")
                .allowedOriginPatterns("https://5173-cs-9ec2fbb7-98c4-448b-ad44-567877072fc1.cs-us-west1-vwey.cloudshell.dev/")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
        }
    }