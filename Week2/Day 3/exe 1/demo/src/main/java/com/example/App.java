package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class App {
    public static void main(String[] args) {
        // Load the Spring context using annotation-based configuration
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class)) {
            
            // Get the greeting service bean from the context
            GreetingService greetingService = context.getBean(GreetingService.class);
            
            // Use the greeting service to say hello
            System.out.println(greetingService.sayGreeting());
        }
        // The context is automatically closed due to the try-with-resources statement
    }
}
